/******************************************************************************
 * Product: Posterita Ajax UI 												  *
 * Copyright (C) 2007 Posterita Ltd.  All Rights Reserved.                    *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Posterita Ltd., 3, Draper Avenue, Quatre Bornes, Mauritius                 *
 * or via info@posterita.org or http://www.posterita.org/                     *
 *****************************************************************************/

package org.adempiere.webui.component;

import java.util.Properties;

import org.adempiere.webui.LayoutUtils;
import org.adempiere.webui.apps.AEnv;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Separator;

/**
* Messagebox : Replaces ZK's Messagebox
*
* @author  Niraj Sohun
* @date    Jul 31, 2007
*/

public class Messagebox extends Window implements EventListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4957498533838144942L;
	private String msg = new String("");
	private String imgSrc = new String("");
	
//	private Label lblMsg = new Label();
	private Text lblMsg = new Text();
	
	private Button btnOk = new Button();
	private Button btnCancel = new Button();
	private Button btnYes = new Button();
	private Button btnNo = new Button();
	private Button btnAbort = new Button();
	private Button btnRetry = new Button();
	private Button btnIgnore = new Button();
	
	private Image img = new Image();

	private int returnValue;
	
	/** A OK button. */
	public static final int OK = 0x0001;
	
	/** A Cancel button. */
	public static final int CANCEL = 0x0002;
	
	/** A Yes button. */
	public static final int YES = 0x0010;
	
	/** A No button. */
	public static final int NO = 0x0020;
	
	/** A Abort button. */
	public static final int ABORT = 0x0100;
	
	/** A Retry button. */
	public static final int RETRY = 0x0200;
	
	/** A IGNORE button. */
	public static final int IGNORE = 0x0400;
	
	/** A symbol consisting of a question mark in a circle. */
	public static final String QUESTION = "~./zul/img/msgbox/question.gif";
	
	/** A symbol consisting of an exclamation point in a triangle with a yellow background. */
	public static final String EXCLAMATION  = "~./zul/img/msgbox/exclamation.gif";
	
	/** A symbol of a lowercase letter i in a circle. */
	public static final String INFORMATION = "~./zul/img/msgbox/information.gif";
	
	/** A symbol consisting of a white X in a circle with a red background. */
	public static final String ERROR = "~./zul/img/msgbox/error.gif";
	
	/** Contains no symbols. */
	public static final String NONE = null;
	
	public Messagebox()
	{
		super();
	}
	
	private void init()
	{
		Properties ctx = Env.getCtx();
		lblMsg.setValue(msg);
		
		btnOk.setLabel(Util.cleanAmp(Msg.getMsg(ctx, "OK")));
		btnOk.setImage("/images/Ok16.png");
		btnOk.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnOk);
			
		btnCancel.setLabel(Util.cleanAmp(Msg.getMsg(ctx, "Cancel")));
		btnCancel.setImage("/images/Cancel16.png");
		btnCancel.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnCancel);

		btnYes.setLabel(Util.cleanAmp(Msg.getMsg(ctx, "Yes")));
		btnYes.setImage("/images/Ok16.png");
		btnYes.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnYes);
		
		btnNo.setLabel(Util.cleanAmp(Msg.getMsg(ctx, "No")));
		btnNo.setImage("/images/Cancel16.png");
		btnNo.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnNo);
		
		btnAbort.setLabel("Abort");
		//btnAbort.setImage("/images/");
		btnAbort.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnAbort);
		
		btnRetry.setLabel("Retry");
		//btnRetry.setImage("/images/");
		btnRetry.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnRetry);
		
		btnIgnore.setLabel("Ignore");
		btnIgnore.setImage("/images/Ignore16.png");
		btnIgnore.addEventListener(Events.ON_CLICK, this);
		LayoutUtils.addSclass("action-text-button", btnIgnore);
		
		Panel pnlMessage = new Panel();
		pnlMessage.setWidth("100%");
		pnlMessage.setStyle("text-align:left");
		pnlMessage.appendChild(lblMsg);

		Panel pnlImage = new Panel();
		
		img.setSrc(imgSrc);
		
		pnlImage.setWidth("100%");
		pnlImage.setStyle("text-align:center");
		pnlImage.appendChild(img);
				
		Hbox hbox = new Hbox();
		hbox.setWidth("100%");
		hbox.setWidths("10%, 90%");
		
		hbox.appendChild(pnlImage);
		hbox.appendChild(pnlMessage);
		
		Hbox pnlButtons = new Hbox();
		pnlButtons.setWidth("100%");
		pnlButtons.setStyle("text-align:center");
		pnlButtons.appendChild(btnOk);
		pnlButtons.appendChild(btnCancel);
		pnlButtons.appendChild(btnYes);
		pnlButtons.appendChild(btnNo);
		pnlButtons.appendChild(btnAbort);
		pnlButtons.appendChild(btnRetry);
		pnlButtons.appendChild(btnIgnore);
		
		this.setWidth("100%");
		this.setBorder("normal");
		this.setContentStyle("background-color:#ffffff");
		this.setPosition("left, top");
		
		Separator blank = new Separator();
		blank.setOrient("vertical");
		blank.setHeight("5px");
		
		hbox.appendChild(blank);
		hbox.appendChild(pnlButtons);
				
		this.appendChild(hbox);
	}
	
	public int show(String message, String title, int buttons, String icon)
	{
		this.msg = message;
		this.imgSrc = icon;
		
		btnOk.setVisible(false);
		btnCancel.setVisible(false);
		btnYes.setVisible(false);
		btnNo.setVisible(false);
		btnRetry.setVisible(false);
		btnAbort.setVisible(false);
		btnIgnore.setVisible(false);
		
		if ((buttons & OK) != 0)
			btnOk.setVisible(true);
		
		if ((buttons & CANCEL) != 0)
			btnCancel.setVisible(true);
		
		if ((buttons & YES) != 0)
			btnYes.setVisible(true);
		
		if ((buttons & NO) != 0)
			btnNo.setVisible(true);
		
		if ((buttons & RETRY) != 0)
			btnRetry.setVisible(true);
		
		if ((buttons & ABORT) != 0)
			btnAbort.setVisible(true);
		
		if ((buttons & IGNORE) != 0)
			btnIgnore.setVisible(true);
		
		init();
		
		if (icon.equals(QUESTION))
		{
			this.setTitle(title);
			this.setWidth("500px");
			this.setPosition("center");
			this.setClosable(true);
			this.setAttribute(Window.MODE_KEY, Window.MODE_MODAL);
			this.setSizable(true);
		}
		else
		{
			this.setTitle(title);
			this.setAttribute(Window.MODE_KEY, Window.MODE_OVERLAPPED);
			this.setWidth("500px");
			this.setClosable(true);
			this.setSizable(true);
		}
		
		this.setVisible(true);
		AEnv.showCenterScreen(this);
		
		return returnValue;
	}
	
	public static int showDialog(String message, String title, int buttons, String icon) throws InterruptedException
	{
		Messagebox msg = new Messagebox();
		
		return msg.show(message, title, buttons, icon);
	}
	
	public void onEvent(Event event) throws Exception 
	{
		if (event == null)
			return;
		
		if (event.getTarget() == btnOk)
		{
			returnValue = OK;
		}
		else if (event.getTarget() == btnCancel)
		{
			returnValue = CANCEL;
		}
		else if (event.getTarget() == btnYes)
		{
			returnValue = YES;
		}
		else if (event.getTarget() == btnNo)
		{
			returnValue = NO;
		}
		else if (event.getTarget() == btnAbort)
		{
			returnValue = ABORT;
		}
		else if (event.getTarget() == btnRetry)
		{
			returnValue = RETRY;
		}
		else if (event.getTarget() == btnIgnore)
		{
			returnValue = IGNORE;
		}
		
		this.detach();
	}
}
