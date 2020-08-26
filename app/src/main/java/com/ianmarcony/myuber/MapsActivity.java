package com.ianmarcony.myuber;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LinearLayout linearLayout;
    private ListView listUber;
    private List<CarUberItem> uberItemList;
    private Button btnCheck;
    private MarkerOptions car_uber;
    private  List<LatLng> positionsUber;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        linearLayout = findViewById(R.id.layoutChoose);
        listUber = findViewById(R.id.listCash);
        btnCheck = findViewById(R.id.btnStartTravel);

        uberItemList = new ArrayList<>();

        uberItemList.add(new CarUberItem(R.drawable.car_1,"Melhor preço","R$ 10.00"));
        uberItemList.add(new CarUberItem(R.drawable.car_2,"Mais conforto e rapidez","R$ 30.00"));
        uberItemList.add(new CarUberItem(R.drawable.car_3,"Compartilhe sua viagem para mais economia","R$ 5.00"));

        listUber.setAdapter(new ListUberAdapter(getApplicationContext(),uberItemList));

       positionsUber = new ArrayList<>();

        positionsUber.add(new LatLng(-3.1336097,-59.9796352));
        positionsUber.add(new LatLng(-3.1337277,-59.9796112));
        positionsUber.add(new LatLng(-3.1337627,-59.9788922));
        positionsUber.add(new LatLng(-3.1339101,-59.9800365));


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(positionsUber.get(0)));
                Handler handler = new Handler();


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    marker.remove();
                                        car_uber.position(positionsUber.get(1));

                                        marker = mMap.addMarker(car_uber);
                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(positionsUber.get(1)));


                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            marker.remove();
                                            car_uber.position(positionsUber.get(2));
                                            marker = mMap.addMarker(car_uber);
                                            mMap.moveCamera(CameraUpdateFactory.newLatLng(positionsUber.get(2)));

                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    marker.remove();
                                                    car_uber.position(positionsUber.get(3));
                                                    marker = mMap.addMarker(car_uber);
                                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(positionsUber.get(3)));


                                                }
                                            }, 2000);


                                        }
                                    }, 2000);

                                }
                            }, 2000);






            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);






        // Add a marker in Sydney and move the camera
        LatLng fmm = new LatLng(-3.1340037, -59.9797792);
        MarkerOptions destino = new MarkerOptions().position(fmm).title("Destino FMM").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
        car_uber = new MarkerOptions().position(positionsUber.get(0)).title("Seu Motorista").icon(BitmapDescriptorFactory.fromResource(R.drawable.car_uber));


        mMap.addMarker(destino);
        marker=mMap.addMarker(car_uber);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fmm));





    }


}