package com.coderbd.listviewsearch;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	// Declare Variables
	ListView list;
	ListViewAdapter adapter;
	EditText editsearch;
	String[] rank;
	String[] country;
	String[] population;
	int[] flag;
	ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);

		// Generate sample data
		rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		country = new String[] { "China", "India", "United States",
				"Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
				"Russia", "Japan" };

		population = new String[] { "1,354,040,000", "1,210,193,422",
				"315,761,000", "237,641,326", "193,946,886", "182,912,000",
				"170,901,000", "152,518,015", "143,369,806", "127,360,000" };
		
		flag = new int[] { R.drawable.china, R.drawable.india,
				R.drawable.unitedstates, R.drawable.indonesia,
				R.drawable.brazil, R.drawable.pakistan, R.drawable.nigeria,
				R.drawable.bangladesh, R.drawable.russia, R.drawable.japan };

		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listview);

		for (int i = 0; i < rank.length; i++) 
		{
			WorldPopulation wp = new WorldPopulation(rank[i], country[i],
					population[i], flag[i]);
			// Binds all strings into an array
			arraylist.add(wp);
		}

		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter(this, arraylist);
		
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		
		// Locate the EditText in listview_main.xml
		editsearch = (EditText) findViewById(R.id.search);

		// Capture Text in EditText
		editsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
				adapter.filter(text);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
			}
		});
	}
}
