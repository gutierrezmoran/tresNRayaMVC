package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;

public class TresNRayaUI extends JFrame {

	protected JPanel contentPane;
	protected Botonera botonera;
	protected JLabel txtMensaje;
	protected JLabel txtTurno;
	protected JLabel txtJugada;
	protected JButton btnReiniciar;
	protected JLabel txtEstado;
	protected JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonera=new Botonera();
		botonera.setBackground(new Color(220, 220, 220));
		botonera.setBounds(0, 55, 380, 380);
		botonera.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(botonera);
		botonera.setLayout(new BorderLayout(0, 0));
		
		JPanel Titulo = new JPanel();
		Titulo.setOpaque(true);
		Titulo.setBackground(Color.DARK_GRAY);
		Titulo.setForeground(Color.WHITE);
		Titulo.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		Titulo.setBounds(0, 0, 380, 52);
		contentPane.add(Titulo);
		Titulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("TRES EN RAYA");
		lblTitulo.setForeground(SystemColor.controlHighlight);
		lblTitulo.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 40));
		lblTitulo.setBounds(10, 0, 370, 47);
		Titulo.add(lblTitulo);
		
		txtMensaje = new JLabel("");
		txtMensaje.setVisible(false);
		txtMensaje.setOpaque(true);
		txtMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		txtMensaje.setBackground(Color.RED);
		txtMensaje.setBounds(0, 571, 380, 35);
		contentPane.add(txtMensaje);
		
		txtJugada = new JLabel("");
		txtJugada.setHorizontalAlignment(SwingConstants.LEFT);
		txtJugada.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtJugada.setBounds(351, 437, 27, 18);
		contentPane.add(txtJugada);
		
		txtTurno = new JLabel("");
		txtTurno.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurno.setFont(new Font("Arial", Font.BOLD, 30));
		txtTurno.setBounds(4, 439, 30, 30);
		contentPane.add(txtTurno);
		
		JLabel lblJugadaActual = new JLabel("JUGADA ACTUAL");
		lblJugadaActual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugadaActual.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblJugadaActual.setBounds(209, 437, 132, 18);
		contentPane.add(lblJugadaActual);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReiniciar.setBorder(null);
		btnReiniciar.setBackground(Color.ORANGE);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReiniciar.setVisible(false);
		btnReiniciar.setFocusPainted(false);
		btnReiniciar.setBounds(219, 516, 149, 44);
		btnReiniciar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btnReiniciar.setBackground(new Color(255, 219, 86));
			}

			public void mouseExited(MouseEvent e) {
				btnReiniciar.setBackground(Color.ORANGE);
			}
		});
		contentPane.add(btnReiniciar);
		
		txtEstado = new JLabel("COLOCA FICHA");
		txtEstado.setForeground(Color.GRAY);
		txtEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEstado.setFont(new Font("Arial Black", Font.BOLD, 10));
		txtEstado.setBounds(235, 456, 106, 18);
		contentPane.add(txtEstado);
		
		JLabel lblDesarrolladoPorJos = new JLabel("Desarrollado por Jos\u00E9 Emilio Guti\u00E9rrez");
		lblDesarrolladoPorJos.setFont(new Font("Arial", Font.BOLD, 11));
		lblDesarrolladoPorJos.setForeground(Color.DARK_GRAY);
		lblDesarrolladoPorJos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladoPorJos.setBounds(10, 581, 358, 14);
		contentPane.add(lblDesarrolladoPorJos);
		
		btnCancelar = new JButton("X");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setVisible(false);
		btnCancelar.setBorder(null);
		btnCancelar.setForeground(new Color(200, 0, 0));
		btnCancelar.setBackground(new Color(255, 200, 200));
		btnCancelar.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnCancelar.setBounds(349, 458, 15, 15);
		contentPane.add(btnCancelar);
	}
}
