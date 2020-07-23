/*
 * ISC-License
 *
 * Copyright 2020 Laslo Hunhold <laslo@hunhold.de>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package Postfix;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Programmierpraktikum (Sommersemester 2020)
 * 
 * M.Sc. Laslo Hunhold
 * Dept. Math./Inf., Abt. Informatik
 * Universität zu Köln
 * Meilenstein 1 (18.05.2020)
 * 
 * +++ GUI-Klasse +++
 * 
 * Diese Klasse ist für die grafische Benutzeroberfläche verantwortlich.
 * Diese wurde uns zur Verfügung gestellt.
 * 
 * +++ +++ +++ +++ +++ +++
 * 
 * @author Laslo Hunhold
 * 
 */
public class GUI implements ActionListener, ListSelectionListener, FocusListener {

	DefaultListModel<String> verlauf;
	JTextField input;
	JList<String> liste;
	JLabel status;
	
	public GUI() {
		
		JFrame frame= new JFrame("Rechner");
		Font fontmain= new Font("Serif", Font.BOLD, 15);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setFont(fontmain);
		
		Font fontlarge= new Font("Serif", Font.BOLD, 30);
		input= new JTextField();
		input.setFont(fontlarge);
		input.addActionListener(this);
		
		verlauf= new DefaultListModel<>();
		liste= new JList<>(verlauf);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(this);
		liste.addFocusListener(this);
		JScrollPane sp= new JScrollPane();
		sp.setViewportView(liste);
		
		status= new JLabel("");
		
		frame.getContentPane().add(BorderLayout.NORTH, input);
		frame.getContentPane().add(BorderLayout.CENTER, sp);
		frame.getContentPane().add(BorderLayout.SOUTH, status);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new GUI();
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		String result= null;
		
		try {
			result= Postfix.eval(input.getText());
		} catch (Exception ex) {
			status.setText(ex.getMessage());
		}
		
		if (result != null) {
			verlauf.insertElementAt(input.getText(), 0);
			input.setText(result);
			input.setCaretPosition(0);
			status.setText("");
		}
			
	}
	
	
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting() && liste.getSelectedValue() != null) {
			input.setText(liste.getSelectedValue().toString());
		}
		
	}
	
	
	public void focusGained(FocusEvent e) {
		
		return;
		
	}
	
	
	public void focusLost(FocusEvent e) {
		
		liste.clearSelection();
		
	}
	

	
}
