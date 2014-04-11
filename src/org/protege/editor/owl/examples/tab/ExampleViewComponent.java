package org.protege.editor.owl.examples.tab;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;
import org.protege.owl.example.Metrics;
import org.yaolabs.epilepsy.counting.CreateTable;


public class ExampleViewComponent extends AbstractOWLViewComponent {
    private static final long serialVersionUID = -4515710047558710080L;
    
    private static final Logger log = Logger.getLogger(ExampleViewComponent.class);
    
	JTextArea txt = new JTextArea();
	JScrollPane scrolltxt = new JScrollPane(txt);
	private JButton RunFile = new JButton("Run for this File");
 
	JPanel refreshpanel = new JPanel();

 
    
    private Metrics metricsComponent;
    private Metrics1 metricsComponent1;
       @Override
    protected void initialiseOWLView() throws Exception {
//         setLayout(new BorderLayout());
    	   refreshpanel.add(RunFile);
        metricsComponent = new Metrics(getOWLModelManager());
        metricsComponent1 = new Metrics1(getOWLModelManager().getActiveOntology());
        
        PrintStream con=new PrintStream(new TextAreaOutputStream(txt ,10000));
        PrintStream ps = new PrintStream( con );
        System.setOut(ps);
        System.setErr(ps);
        txt.append("The Currently Loaded Ontology is :" + getOWLModelManager().getActiveOntology() + "\n");
		txt.append("PLEASE CLICK ON RUN BUTTON TO SHOW THE OUTPUT TABLE" + "\n" + "\n");
		scrolltxt.setBounds(3, 3, 1000, 1000);
		add(scrolltxt , BorderLayout.SOUTH);	
		add(RunFile);
		setVisible(true);
		
		/*ADD CONSOLE OUTPUTS BELOW TO PRINT STUFF*/
//		for(int i=0 ; i<100 ; i++)
			System.out.println("************CONSOLE OUTPUT IS DISPLAYED HERE : **************");
		
//		CreateTable obj = new CreateTable();
//		obj.main(null);
//		
		setLayout(new BorderLayout());
 
		add(metricsComponent1, BorderLayout.EAST); /*Refresh button action on click*/
//        add(metricsComponent, BorderLayout.CENTER);
        log.info("Example View Component initialized");
    }

    
  
	@Override
	protected void disposeOWLView() {
		metricsComponent.dispose();
		RunFile.removeActionListener(null);

	}

}
