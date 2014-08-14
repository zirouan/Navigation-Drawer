package br.liveo.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import br.liveo.navigationliveo.R;
import br.liveo.utils.Constant;
import br.liveo.utils.Menus;

public class RouteFragment extends Fragment {
	
	private TextView mTxtRoute;
	private boolean mSearchCheck;
	
	public RouteFragment newInstance(String text){
		RouteFragment mFragment = new RouteFragment();		
		Bundle mBundle = new Bundle();
		mBundle.putString(Constant.TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.route_fragment, container, false);		
						
		mTxtRoute = (TextView) rootView.findViewById(R.id.txtRoute);
		mTxtRoute.setText(getArguments().getString(Constant.TEXT_FRAGMENT));
		
		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return rootView;		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);										
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);		
		inflater.inflate(R.menu.menu, menu);
		 	    
		final MenuItem searchMenuItem = menu.findItem(Menus.SEARCH);
		final SearchView searchView = (SearchView) searchMenuItem.getActionView();
		searchView.setQueryHint(this.getString(R.string.search));
		int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
		((EditText) searchView.findViewById(id)).setHintTextColor(getResources().getColor(R.color.white));
		searchView.setOnQueryTextListener(OnQuerySearchView);
					    	   	    
		menu.findItem(Menus.ADD).setVisible(true);
		menu.findItem(Menus.SEARCH).setVisible(true);		
  	    
		mSearchCheck = false;	
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case Menus.ADD:	    	
			break;				
			
		case Menus.SEARCH:
			mSearchCheck = true;
			break;
		}		
		return true;
	}	
	
	private OnQueryTextListener OnQuerySearchView = new OnQueryTextListener() {
		
		@Override
		public boolean onQueryTextSubmit(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean onQueryTextChange(String arg0) {
			// TODO Auto-generated method stub
			if (mSearchCheck){
				// implement your search here
			}
			return false;
		}
	};	
}
