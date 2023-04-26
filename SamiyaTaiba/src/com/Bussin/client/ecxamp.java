package com.Bussin.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.tools.ant.taskdefs.Javadoc.Html;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialCard;

public class ecxamp extends Composite {

	private static ecxampUiBinder uiBinder = GWT.create(ecxampUiBinder.class);
	@UiField
	MaterialCard Cardimg;
	
	//String Images="https://th.bing.com/th/id/OIP.R8OXSsyZ4Ojy6HMmq5G5tAHaDn?pid=ImgDet&w=192&h=93&c=7";
	String Images="//SamiyaTaiba/war/image/alre.jpg";
	
	interface ecxampUiBinder extends UiBinder<Widget, ecxamp> {
	}

	public ecxamp() throws IOException {
		initWidget(uiBinder.createAndBindUi(this));
		//Cardimg.getElement().getStyle().setBackgroundImage().getResour
		Image image = null;
		Widget h =new Widget();
		
		/*SafeHtmlUtils s= new SafeHtmlUtils(); 
			/**
			 * 
			 
			private static final long serialVersionUID = 1L;
			SafeHtmlBuilder sb=new SafeHtmlBuilder();
			@Override
			public String asString() {
				// TODO Auto-generated method stub
				sb.appendHtmlConstant("<img src='F:/image' alt='HTML5 Icon' style='width:410px;height:33028px;'>");
				
				return null;
			}
		};**/
		Image img= new Image();
		img.setPixelSize(410,380);
		img.setUrl(Images);
	//Cardimg.add(img);
		Cardimg.setTooltipHTML("<img src='//SamiyaTaiba/war/WEB-INF/alre.jpg'/>");
		//Cardimg.setTooltipHTML("<h1>skfhkhfskssssssssssssssssssssssssssssssssssssssssssssssssssssssssdafaffgag</h1>");
		//Cardimg.setTooltipHTML("<div><img src='F://alre.jpg' alt='Girl in a jacket' style='width:500px;height:600px;' ");
		
	    //File sourceimage = new File("c:\\mypic.jpg");
		//image = ImageIO.read(sourceimage)
	    //Cardimg.getElement().getStyle().setBackgroundImage("src("+Images+")");
	   // Cardimg.getElement().getStyle().setBackgroundImage("url("+Images+")");
	}

	
}
