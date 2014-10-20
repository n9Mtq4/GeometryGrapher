package com.n9mtq4.math.sysin;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 * Created by Will on 10/19/14.
 */
public class NTextArea extends JTextPane {
	
	private boolean userEditable;
	
	public NTextArea() {
		this.userEditable = false;
	}
	
	public NTextArea(StyledDocument styledDocument) {
		super(styledDocument);
		this.userEditable = false;
	}
	
	public void append(String msg, Color c) {
		boolean edit = super.isEditable();
		super.setEditable(true);
//		thanks nIcE cOw @ stackoverflow
//		https://stackoverflow.com/questions/9650992/how-to-change-text-color-in-the-jtextarea
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
		
		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		
		int len = this.getDocument().getLength();
		this.setCaretPosition(len);
		this.setCharacterAttributes(aset, false);
		this.replaceSelection(msg);
		super.setEditable(edit);
	}
	
	public boolean isUserEditable() {
		return userEditable;
	}
	
	public void setUserEditable(boolean userEditable) {
		this.userEditable = userEditable;
		if (!userEditable) {
			setEditable(false);
		}
	}
	
}
