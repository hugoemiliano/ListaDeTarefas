package info.hugoemiliano.listadetarefas;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	ArrayList<String> tarefas;
	ArrayAdapter<String> adapterTarefas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tarefas = new ArrayList<String>();
		adapterTarefas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, tarefas);
		ListView listaTarefas = (ListView) findViewById(R.id.listViewTarefa);
		listaTarefas.setAdapter(adapterTarefas);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void cadastrar(View v) {
		EditText txtTarefa = (EditText) findViewById(R.id.txtTarefa); 
		String tarefa = txtTarefa.getText().toString();
		if(!tarefa.isEmpty()){
			tarefas.add(tarefa);
			adapterTarefas.notifyDataSetChanged();
			txtTarefa.setText("");
			
		}
		
	}
	
}
