package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI {

	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);
	int a = 0;
	int b = 0;
	int x;
	int y;

	public ParaTresNRayaUI() {
		super();
		
		Timer timer = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splash.setVisible(false);
				botonera.setVisible(true);
			}
		});
		
		timer.start();
		
		inicializarPartida();

		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarPartida();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarSeleccionMover();
			}
		});
		
		btnReiniciar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btnReiniciar.setBackground(new Color(255, 219, 86));
			}

			public void mouseExited(MouseEvent e) {
				btnReiniciar.setBackground(Color.ORANGE);
			}
		});

	}

	/**
	 * Ejecuta la partida
	 * 
	 * @param coordenada
	 *            Nombre del boton que representa su coordenada dentro de una matriz
	 */
	public void jugar(String coordenada) {
		this.x = Character.getNumericValue(coordenada.charAt(0));
		this.y = Character.getNumericValue(coordenada.charAt(1));

		control.destinox = x;
		control.destinoy = y;

		if (control.realizarJugada()) {
			botonera.getBotones()[x][y].setText(String.valueOf(control.retornaSimbolo(control.verTurno())));

			if (control.numerojugada > 6) {
				txtEstado.setText("MUEVE FICHA");
			}

			if (!control.mover) {
				this.a = x;
				this.b = y;

				botonera.getBotones()[x][y].setEnabled(false);
				btnCancelar.setVisible(true);
			} else {
				btnCancelar.setVisible(false);
				botonera.getBotones()[this.a][this.b]
						.setBackground(botonera.obtenerBackgroundBoton(botonera.getMAXR(), botonera.getMINR(),
								botonera.getMAXG(), botonera.getMING(), botonera.getMAXB(), botonera.getMINB()));
				botonera.getBotones()[this.a][this.b].setEnabled(true);
			}
			txtMensaje.setVisible(false);
		} else {

			txtMensaje.setVisible(true);
			txtMensaje.setText(control.indicarAnomalia());
		}

		if (control.numerojugada >= 6) {
			if (control.comprobarTresEnRaya()) {
				finalizarPartida();
			}
		}

		actualizarPartida(false);
	}

	/**
	 * Actualiza el estado de la partida
	 * 
	 * @param finalizar
	 *            Representa si la partida ha terminado
	 */
	private void actualizarPartida(boolean finalizar) {
		txtJugada.setText(String.valueOf(control.numerojugada));
		txtTurno.setText(String.valueOf(control.retornaSimbolo(control.verTurno())));

		for (int i = 0; i < botonera.getBotones().length; i++) {
			for (int j = 0; j < botonera.getBotones()[i].length; j++) {
				botonera.getBotones()[i][j].setText(String.valueOf(control.retornaSimbolo(control.tablero[i][j])));
				if (finalizar) {
					cerrarBotonera(i, j);
				}
			}
		}
		if (finalizar) {
			control.numerojugada -= 1;
			txtJugada.setText(String.valueOf(control.numerojugada));
		}

	}

	/**
	 * Deshabilita la botonera
	 * 
	 * @param i
	 *            Posicion del boton en la matriz
	 * @param j
	 *            Posicion del boton en la matriz
	 */
	private void cerrarBotonera(int i, int j) {
		btnReiniciar.setVisible(true);
		botonera.getBotones()[i][j].setEnabled(false);
		if (control.tablero[i][j] == control.verTurno()) {
			botonera.getBotones()[i][j].setBackground(new Color(178, 255, 208));
		} else {
			botonera.getBotones()[i][j].setBackground(Color.WHITE);
		}
	}

	/**
	 * Finaliza la partida
	 */
	private void finalizarPartida() {
		control.numerojugada++;
		txtMensaje.setText("Jugador '" + control.retornaSimbolo(control.verTurno()) + "', TU GANAS");
		txtMensaje.setBackground(new Color(0, 93, 67));
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setVisible(true);
		actualizarPartida(true);
	}

	/**
	 * Restablece los valores de la partida a su estado inicial
	 */
	private void reiniciarPartida() {
		int[][] tableroVacio = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		control.tablero = tableroVacio;
		control.numerojugada = 2;
		control.mover = true;
		btnReiniciar.setVisible(false);
		btnCancelar.setVisible(false);
		txtMensaje.setBackground(Color.RED);
		txtMensaje.setVisible(false);
		txtEstado.setText("COLOCA FICHA");
		for (int i = 0; i < botonera.getBotones().length; i++) {
			for (int j = 0; j < botonera.getBotones()[i].length; j++) {
				botonera.getBotones()[i][j].setEnabled(true);
				botonera.getBotones()[i][j]
						.setBackground(botonera.obtenerBackgroundBoton(botonera.getMAXR(), botonera.getMINR(),
								botonera.getMAXG(), botonera.getMING(), botonera.getMAXB(), botonera.getMINB()));
				actualizarPartida(false);
			}
		}
	}

	/**
	 * Asigna valores iniciales a los diferentes componentes graficos de la partida
	 */
	private void inicializarPartida() {
		this.botonera.getBotones()[1][1].setText("O");
		txtJugada.setText(String.valueOf(control.numerojugada));
		txtTurno.setText(String.valueOf(control.retornaSimbolo(control.verTurno())));
		txtMensaje.setText(control.muestraLetrero());

		for (int i = 0; i < this.botonera.getBotones().length; i++) {
			for (int j = 0; j < this.botonera.getBotones()[i].length; j++) {
				this.botonera.getBotones()[i][j].addActionListener(listener);
			}
		}
	}

	/**
	 * Deshace la seleccion de una casilla que se quiere mover
	 */
	private void cancelarSeleccionMover() {
		for (int i = 0; i < botonera.getBotones().length; i++) {
			for (int j = 0; j < botonera.getBotones().length; j++) {
				if (!botonera.getBotones()[i][j].isEnabled()) {
					botonera.getBotones()[i][j].setEnabled(true);
					control.mover = true;
					btnCancelar.setVisible(false);
				}
			}
		}
	}
}
