package org.protege.editor.owl.examples.tab;


import java.awt.event.ActionEvent;						
import java.awt.event.ActionListener;						

import javax.swing.JButton;							
import javax.swing.JLabel;							
import javax.swing.JPanel;					

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.yaolabs.epilepsy.counting.CreateTable;
import org.yaolabs.epilepsy.inferences.EEG;
import org.yaolabs.epilepsy.inferences.Graph;


import org.yaolabs.epilepsy.counting.ExcelExporter;
import org.yaolabs.epilepsy.inferences.Vector;

public class Metrics1 extends JPanel {
  	    private static final long serialVersionUID = -2017045836890114258L;

private JLabel textComponent = new JLabel();
 private JButton refreshButton = new JButton("RunOWLFile");
 private JButton inferenceButton = new JButton("RunOWLFileAgain");
		    private ActionListener refreshAction = new ActionListener() {

			        public void actionPerformed(ActionEvent e) {
            try {
				recalculate();
			} catch (OWLOntologyCreationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}						
        }									        
        									        
    };										    
    		
    
    private ActionListener inferenceAction = new ActionListener() {

    public void actionPerformed(ActionEvent e) {
try {
	findInference();
} catch (OWLOntologyCreationException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}						
}									        
								        
};
    
    
    private static OWLOntology ontology ;						   
	
		    

    public Metrics1(OWLOntology ontology) {					    
        this.ontology = ontology;						        
//        recalculate();								       
        refreshButton.addActionListener(refreshAction);
        inferenceButton.addActionListener(inferenceAction);
        add(textComponent);							       
        add(refreshButton);
        add(inferenceButton);
    }										    
    										    
    public void dispose() {							   
        refreshButton.removeActionListener(refreshAction);
       inferenceButton.removeActionListener(refreshAction);
    }										    
    										    
    public void setOWLOntology(OWLOntology  ontology) {				
        this.ontology = ontology;						   
    }									
    										    
    private void recalculate() throws OWLOntologyCreationException {	
    	System.out.println(ontology.getOntologyID());
    	CreateTable obj = new CreateTable(ontology);		
		obj.main(null);		     
    }					
    
    private void findInference() throws OWLOntologyCreationException {	
    	System.out.println(ontology.getOntologyID());
    	EEG eeg = new EEG(ontology);	
    	//Graph graph = new Graph();
    	Vector v = new Vector();
    	ExcelExporter export = new ExcelExporter();
		eeg.main(null);		  
    }				
}										