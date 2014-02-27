package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;import com.example.ActionBar.R;

/**
 * Created by christerhansen on 27.02.14.
 */
public class TastaturFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tastatur_layout, container, false);
    }
}