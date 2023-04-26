package com.Bussin.client;


import java.text.Normalizer.Form;

import org.eclipse.jetty.client.api.Connection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;

import gwt.material.design.client.ui.MaterialLabel;

public class FileUploadDesigns extends Composite  {

	private static FileUploadDesignsUiBinder uiBinder = GWT.create(FileUploadDesignsUiBinder.class);

	interface FileUploadDesignsUiBinder extends UiBinder<Widget, FileUploadDesigns> {
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	private static final String UPLOAD_ACTION_URL =GWT.getModuleBaseURL()+"/upload";
	
	//GWT.getModuleBaseURL()+
	Grid grid = new Grid(1,1);
	public FileUploadDesigns() {
		Window.alert(UPLOAD_ACTION_URL);
		
		 VerticalPanel panel = new VerticalPanel();
		 //System.out.print(UPLOAD_ACTION_URL+"UPLOAD_ACTION_URL");
		 
	      //create a FormPanel 
	      FormPanel form = new FormPanel();
	      //create a file upload widget
	      final FileUpload fileUpload = new FileUpload();
	      //create labels
	     
	      MaterialLabel selectLabel = new MaterialLabel("Select a file:");
	      //create upload button
	      Button uploadButton = new Button("Upload File");
	      form.setAction(UPLOAD_ACTION_URL);
     	  form.setEncoding(form.ENCODING_MULTIPART);
	      form.setMethod(form.METHOD_POST);
	     
	     
	     
	      //add a label
	      panel.add(selectLabel);
	      //add fileUpload widget
	      panel.add(fileUpload);
	      //add a button to upload the file
	      panel.add(uploadButton);
	      
	     
	      uploadButton.addClickHandler(new ClickHandler() {
	    	  
	    	
	         @Override
	         public void onClick(ClickEvent event) {
	            //get the filename to be uploaded
	            String filename = fileUpload.getFilename();
	           
	            Window.alert(filename);
	            if (filename.length() == 0) {
	               Window.alert("No File Specified!");
	            } else {
	               //submit the form
	            	//jsClickUpload( filename.getFilename() );
	            	
	            	form.getElement();
	            	form.submit();	
	            }				
	         }
	      });
	      
    form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
	         @Override
	         public void onSubmitComplete(SubmitCompleteEvent event) {
	            // When the form submission is successfully completed, this 
	            //event is fired. Assuming the service returned a response 
	            //of type text/html, we can get the result text here 
	        	 
	            Window.alert(event.getResults());				
	         }
	      });
	      panel.setSpacing(10);
		  
	      // Add form to the root panel.      
	      form.add(panel);      

	      RootPanel.get().add(form);
	}

	

}
