package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI {

	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);
	int a = 0;
	int b = 0;

	public ParaTresNRayaUI() {
		super();

		// Iniciamos el tablero y los mensajes
		this.botonera.botones[1][1].setText("O");
		txtJugada.setText(String.valueOf(control.numerojugada));
		txtTurno.setText(String.valueOf(control.retornaSimbolo(control.verTurno())));
		txtMensaje.setText(control.muestraLetrero());

		// Preparamos la botonera añadiendo los listener
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
			}
		}

		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarPartida();
			}
		});

	} // CIERRE CONSTRUCTOR

	public void jugar(String coordenada) {
		int x = Character.getNumericValue(coordenada.charAt(0));
		int y = Character.getNumericValue(coordenada.charAt(1));

		control.destinox = x;
		control.destinoy = y;

		if (control.realizarJugada()) {
			botonera.botones[x][y].setText(String.valueOf(control.retornaSimbolo(control.verTurno())));
			if(!control.mover) {
				this.a = x;
				this.b = y;
				//botonera.botones[x][y].setBackground(Color.BLUE);
				botonera.botones[x][y].setEnabled(false);
			} else {
				//botonera.botones[x][y].setBackground(botonera.obtenerBackgroundBoton(botonera.getMAXR(), botonera.getMINR(),
						//botonera.getMAXG(), botonera.getMING(), botonera.getMAXB(), botonera.getMINB()));
				botonera.botones[this.a][this.b].setBackground(botonera.obtenerBackgroundBoton(botonera.getMAXR(), botonera.getMINR(),
						botonera.getMAXG(), botonera.getMING(), botonera.getMAXB(), botonera.getMINB()));
				botonera.botones[this.a][this.b].setEnabled(true);
			}
			txtMensaje.setVisible(false);
		} else {
			txtMensaje.setVisible(true);
			txtMensaje.setText(control.indicarAnomalia());
		}

		if (control.numerojugada >= 6) {
			if (control.comprobarTresEnRaya()) {
				finalizarJuego();
			}
		}

		actualizarJuego(false);
	}

	private void actualizarJuego(boolean finalizar) {
		txtJugada.setText(String.valueOf(control.numerojugada));
		txtTurno.setText(String.valueOf(control.retornaSimbolo(control.verTurno())));

		for (int i = 0; i < botonera.botones.length; i++) {
			for (int j = 0; j < botonera.botones[i].length; j++) {
				botonera.botones[i][j].setText(String.valueOf(control.retornaSimbolo(control.tablero[i][j])));
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

	private void cerrarBotonera(int i, int j) {
		btnReiniciar.setVisible(true);
		botonera.botones[i][j].setEnabled(false);
		if (control.tablero[i][j] == control.verTurno()) {
			botonera.botones[i][j].setBackground(new Color(178, 255, 208));
		} else {
			botonera.botones[i][j].setBackground(Color.WHITE);
		}
	}

	private void finalizarJuego() {
		control.numerojugada++;
		txtMensaje.setText("Jugador '" + control.retornaSimbolo(control.verTurno()) + "', TU GANAS");
		txtMensaje.setBackground(new Color(0, 93, 67));
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setVisible(true);
		actualizarJuego(true);
	}

	private void reiniciarPartida() {
		int[][] tableroVacio = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		control.tablero = tableroVacio;
		control.numerojugada = 2;
		control.mover = true;
		btnReiniciar.setVisible(false);
		txtMensaje.setVisible(false);
		for (int i = 0; i < botonera.botones.length; i++) {
			for (int j = 0; j < botonera.botones[i].length; j++) {
				botonera.botones[i][j].setEnabled(true);
				botonera.botones[i][j]
						.setBackground(botonera.obtenerBackgroundBoton(botonera.getMAXR(), botonera.getMINR(),
								botonera.getMAXG(), botonera.getMING(), botonera.getMAXB(), botonera.getMINB()));
				actualizarJuego(false);
			}
		}
	}
}
