package com.Bussin.client;


import java.io.File;

import javax.servlet.http.HttpServlet;

import com.Bussin.shared.Event;
import com.google.gwt.aria.client.ImgRole;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.constants.CenterOn;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardImage;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
public class Homepage extends Composite  {

	private static HomepageUiBinder uiBinder = GWT.create(HomepageUiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface HomepageUiBinder extends UiBinder<Widget, Homepage> {
	}
	int i;
	MaterialCard card;
	@UiField
	Panel t; 
	@UiField
	MaterialLink ADMIN;
	
	public Homepage() {
		initWidget(uiBinder.createAndBindUi(this));
		a1.eventdisplay(null,new AsyncCallback<Event[]>() {		@Override
		public void onSuccess(Event[] result) {
			// TODO Auto-generated method stub
		
			
			
			MaterialPanel p1 = new MaterialPanel();
			MaterialRow r1 = new MaterialRow();
			for (i = 1; i < result.length; i++) {
				//image
				//File folder = new File("C:/Users/owner/eclipse-workspace/SamiyaTaiba/war/image/");
				//Window.alert(folder.getAbsolutePath());
				
				String src=System.getProperty("user.dir");
				System.out.println(src);
				//Window.alert(src);
				MaterialColumn c1 = new MaterialColumn();
				Image img= new Image();
				img.setPixelSize(410,380);
				img.setUrl(src);
				
				card = new MaterialCard();

				card.setBackgroundColor(Color.BLUE_GREY_DARKEN_1);
				MaterialCardContent cont= new MaterialCardContent();
				cont.setTextColor(Color.WHITE);
				MaterialCardTitle t1 = new MaterialCardTitle();
				String CardTitle="Red";
				t1.setText(CardTitle);
				t1.setIconType(IconType.EVENT);
				t1.setIconPosition(IconPosition.RIGHT);
				
				
				
				MaterialLabel l1 = new MaterialLabel("Name :"+result[i].getPname());
				MaterialLabel l2 = new MaterialLabel("Detail:" + result[i].getDetail());
				MaterialLabel l3 = new MaterialLabel("Cost:" + result[i].getCost());
				MaterialButton reg = new MaterialButton("FOR ODER");
				
				l1.setFontWeight(FontWeight.BOLDER);
				l1.setCenterOn(CenterOn.CENTER_ON_SMALL);
				card.add(img);
				cont.add(t1);
				cont.add(l1);
				cont.add(l2);
				cont.add(l3);
				cont.add(reg);
				card.add(cont);
				c1.add(card);
				c1.setGrid("l4 m4 s12");
				r1.add(c1);
				p1.add(r1);

				RootPanel.get().add(p1);
				reg.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						RootPanel.get().clear();
						RootPanel.get().add(new OdderCard());
					}
				});
				}
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
		
	}

	@UiHandler("ADMIN")
	void onClick(ClickEvent e) {
		RootPanel.get().clear();
		RootPanel.get().add(new Login());
	}

}
	

	
