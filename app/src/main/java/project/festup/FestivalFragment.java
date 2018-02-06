package project.festup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import project.festup.model.Festival;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FestivalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FestivalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FestivalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected Festival festival;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FestivalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FestivalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FestivalFragment newInstance(String param1, String param2) {
        FestivalFragment fragment = new FestivalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_festival, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView name = (TextView) getView().findViewById(R.id.inputName);
        TextView description = (TextView) getView().findViewById(R.id.inputDescription);
        TextView information = (TextView) getView().findViewById(R.id.inputInformation);
        TextView begin = (TextView) getView().findViewById(R.id.inputBegin);
        TextView end = (TextView) getView().findViewById(R.id.inputEnd);
        TextView address = (TextView) getView().findViewById(R.id.inputAddress);
        TextView price = (TextView) getView().findViewById(R.id.inputAddress);

        ListView artists = (ListView) getView().findViewById(R.id.artistsList);
        ListView scenes = (ListView) getView().findViewById(R.id.scenesList);
        GridView medias = (GridView) getView().findViewById(R.id.mediaList);
        GridView platforms = (GridView) getView().findViewById(R.id.platformList);

        name.setText(festival.getName());
        description.setText(festival.getDescription());
        information.setText(festival.getInformation());
        begin.setText(festival.getBegin());
        end.setText(festival.getEnd());
        //address.setText(festival.getAddress().toString());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}
