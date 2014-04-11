package org.protege.editor.owl.examples.tab;


				import java.awt.event.ActionEvent;						
import java.awt.event.ActionListener;						

import javax.swing.JButton;							
import javax.swing.JLabel;							
import javax.swing.JPanel;					

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.yaolabs.epilepsy.counting.CreateTable;

public class Metrics1 extends JPanel {
  	    private static final long serialVersionUID = -2017045836890114258L;

private JLabel textComponent = new JLabel();
 private JButton refreshButton = new JButton("RunOWLFile");
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
    										    
    private static OWLOntology ontology ;						   
	
		    

    public Metrics1(OWLOntology ontology) {					    
        this.ontology = ontology;						        
//        recalculate();								       
        refreshButton.addActionListener(refreshAction);				       
        add(textComponent);							       
        add(refreshButton);							      
    }										    
    										    
    public void dispose() {							   
        refreshButton.removeActionListener(refreshAction);			        
    }										    
    										    
    public void setOWLOntology(OWLOntology  ontology) {				
        this.ontology = ontology;						   
    }									
    										    
    private void recalculate() throws OWLOntologyCreationException {	
    	System.out.println(ontology.getOntologyID());
    	CreateTable obj = new CreateTable(ontology);		
		obj.main(null);		     
    }										    
}										