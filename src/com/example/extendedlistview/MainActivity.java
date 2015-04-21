package com.example.extendedlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	ExpandableListAdapters expListAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// getting the listview
		expListView = (ExpandableListView) findViewById(R.id.exp_listview);

		// preparing the list
		preparelist();

		// setting ListAdapter
		expListAdapter = new ExpandableListAdapters(this, listDataHeader,
				listDataChild);
		expListView.setAdapter(expListAdapter);

		// set listener on expanding the group
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " has been expanded.", Toast.LENGTH_SHORT)
						.show();
			}
		});

		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " has been collapsed.", Toast.LENGTH_SHORT)
						.show();
			}
		});

		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataChild.get(listDataHeader.get(groupPosition))
								.get(childPosition)
								+ " of the header "
								+ listDataHeader.get(groupPosition)
								+ " has been selected.", Toast.LENGTH_SHORT)
						.show();
				return true;
			}
		});
	}

	private void preparelist() {
		// TODO Auto-generated method stub
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// setting the header list
		listDataHeader.add("List1");
		listDataHeader.add("List2");
		listDataHeader.add("List3");
		listDataHeader.add("List4");

		// setting up child list within the header
		List<String> List1 = new ArrayList<String>();
		List1.add("Child11");
		List1.add("Child12");
		List1.add("Child13");
		List1.add("Child14");

		List<String> List2 = new ArrayList<String>();
		List2.add("Child21");
		List2.add("Child23");
		List2.add("Child22");

		List<String> List3 = new ArrayList<String>();
		List3.add("Child31");
		List3.add("Child32");
		List3.add("Child33");

		List<String> List4 = new ArrayList<String>();
		List4.add("Child41");
		List4.add("Child42");
		List4.add("Child43");

		listDataChild.put(listDataHeader.get(0), List1);
		listDataChild.put(listDataHeader.get(1), List2);
		listDataChild.put(listDataHeader.get(2), List3);
		listDataChild.put(listDataHeader.get(3), List4);
	}

}
