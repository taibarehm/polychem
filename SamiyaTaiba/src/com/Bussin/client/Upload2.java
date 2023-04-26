package com.Bussin.client;

import com.Bussin.shared.AdminL;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

import gwt.material.design.client.ui.MaterialAnchorButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;       

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Upload2 extends Composite{

	private static Upload2UiBinder uiBinder = GWT.create(Upload2UiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	public String Fname;
	interface Upload2UiBinder extends UiBinder<Widget, Upload2> {
	}
	
	@SuppressWarnings("deprecation")
	public Upload2() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialCard card=new MaterialCard();
		 final FormPanel uploadForm = new FormPanel();
		 uploadForm.setAction("http://127.0.0.1:8888/samiyataiba/upload");

		
		 // form to use the POST method, and multipart MIME encoding.
		 uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		 uploadForm.setMethod(FormPanel.METHOD_POST);
		 
		 // Create a panel to hold all of the form widgets.
		 VerticalPanel panel = new VerticalPanel();
		 uploadForm.setWidget(panel);
		 
		 // Create a FileUpload widget.
		 FileUpload upload = new FileUpload();
		 upload.setName("uploadFormElement");
		 panel.add(upload);

		 // Add a 'submit' button.  
		 
		 Button uploadSubmitButton = new Button("Submit");
		 panel.add(uploadSubmitButton);

		 uploadSubmitButton.addClickListener(new ClickListener() {
		 public void onClick(Widget sender) {
			 Fname=upload.getFilename();
			 
		 uploadForm.submit();
		 }
		 });

		 uploadForm.addFormHandler(new FormHandler() {
		 public void onSubmit(FormSubmitEvent event) {
		 }

		 public void onSubmitComplete(FormSubmitCompleteEvent event) {
			 if(event.getResults().contains("uploaded"))
			 {
				 //Window.alert("Uploaded");
				 
				 MaterialToast.fireToast("Uploaded....");
			 }
			 else {
				 MaterialToast.fireToast("fail to upload");
		     
				 Window.alert(event.getResults());
			 }
		 }
		 });
		 MaterialLabel l1 = new MaterialLabel("ProductID :");
		 MaterialTextBox t1=new MaterialTextBox();
		 MaterialLabel l2 = new MaterialLabel("ProductName :");
		 MaterialTextBox t2=new MaterialTextBox();
		 MaterialLabel l3 = new MaterialLabel("ProductDetail:" );
		 MaterialTextBox t3=new MaterialTextBox();
		 MaterialLabel l4 = new MaterialLabel("ProductCost:");
		 MaterialTextBox t4=new MaterialTextBox();
		 card.add(uploadForm);
		 card.add(l1);
		 card.add(t1);
		 card.add(l2);
		 card.add(t2);
		 card.add(l3);
		 card.add(t3);
		 card.add(l4);
		 card.add(t4);
		 MaterialAnchorButton b1= new MaterialAnchorButton("Upload");
		 b1.setStyle("left:80%");
		 card.add(b1);
		 card.setStyle("padding: 6% 10%");
		 //card.setStyleName("padding: 6% 10%");
		 RootPanel.get().add(card);
		 b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String s1="PS"+t1.getText();
				 String s2=t2.getText();
				 String s3=t3.getText();
				String s4=t4.getText();
				 String s5= upload.getFilename();
				if(t1.getText().isEmpty()||s2.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty())
				{
					MaterialToast.fireToast("Complete the feilds....");
					//Window.alert("Complete the feilds");
				}
				else {
				 AdminL l= new AdminL();
				 l.setName(s2);
				 l.setID(s1);
				 l.setDetail(s3);
				 l.setCost(s4);
				 l.setImg(s5);
				 a1.Uploa(l, new AsyncCallback<String>() {
						
						@Override
						public void onSuccess(String result) {
							
							// TODO Auto-generated method stub
							if (result =="Submited")
							{
								MaterialToast.fireToast("Submited....");
								 RootPanel.get().clear();
								 RootPanel.get().add(new AdminLoad());
							}
							else {
								Window.alert(result);
							}
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}
					});
			}
				
				
			}
		});
		 
		 
		
	}

	

}
