package com.ncertguruji.mopub_poc_yash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubRewardedAdListener;
import com.mopub.mobileads.MoPubRewardedAds;
import com.mopub.mobileads.MoPubView;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener, MoPubRewardedAdListener {
    private MoPubView moPubView;
    private MoPubInterstitial mInterstitial;
    Button bannerAds, InterstitialAds, RewardAds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //banner ads
        moPubView = (MoPubView) findViewById(R.id.mopub_view);
        bannerAds = findViewById(R.id.banner_ads);
        InterstitialAds = findViewById(R.id.interstisial_ads);
        RewardAds = findViewById(R.id.reward_ads);


        bannerAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerads();
            }
        });

        InterstitialAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interstitialads();
            }
        });

        RewardAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RewardAds();
            }
        });

        SdkConfiguration.Builder sdkConfiguration = new SdkConfiguration.Builder("b195f8dd8ded45fe847ad89ed1d016da");
        MoPub.initializeSdk(this, sdkConfiguration.build(), initSdkListener());
    }
    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {

            }
        };
    }
    private void bannerads(){
        moPubView.setAdUnitId("b195f8dd8ded45fe847ad89ed1d016da");
        moPubView.loadAd();
    }
    private void Interstitialads(){
        mInterstitial = new MoPubInterstitial(this, "24534e1901884e398f1253216226017e");
        mInterstitial.setInterstitialAdListener(this);
        mInterstitial.load();
    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
        yourAppsShowInterstitialMethod();
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {

    }

    @Override
    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {

    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {

    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {

    }
    void yourAppsShowInterstitialMethod() {
        if (mInterstitial.isReady()) {
            mInterstitial.show();
        }
    }
    private void RewardAds(){
        MoPubRewardedAds.loadRewardedAd("920b6145fb1546cf8b5cf2ac34638bb7");
        MoPubRewardedAds.setRewardedAdListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        moPubView.destroy();
        mInterstitial.destroy();
    }

    @Override
    public void onRewardedAdClicked(String s) {

    }

    @Override
    public void onRewardedAdClosed(String s) {

    }

    @Override
    public void onRewardedAdCompleted(Set<String> set, MoPubReward moPubReward) {

    }

    @Override
    public void onRewardedAdLoadFailure(String s, MoPubErrorCode moPubErrorCode) {

    }

    @Override
    public void onRewardedAdLoadSuccess(String s) {
        MoPubRewardedAds.showRewardedAd("920b6145fb1546cf8b5cf2ac34638bb7");
    }

    @Override
    public void onRewardedAdShowError(String s, MoPubErrorCode moPubErrorCode) {

    }

    @Override
    public void onRewardedAdStarted(String s) {

    }
}