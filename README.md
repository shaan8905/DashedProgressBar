# DashedProgressBar
## To use this add below lines in your project level gradle
``` sh
allprojects {
	repositories {
	    ...
		maven { url 'https://jitpack.io' }
	}
}
```

## Further add this in your app level
```sh
dependencies {
	 implementation 'com.github.shaan8905:DashedProgressBar:Tag'
}
```

## To customize the progress bar you can use below attributes
| Attributes | Type |
| ------ | ------ |
| sp_progressColor | color |
| sp_bgColor | color |
| sp_stokeWidth | float |
| sp_progressWidth | float |
| sp_dashedWidth | float |

## To use this in your xml use it like below
```
<com.shahnavaz.dashedprogress.customProgress.CustomLineDashedProgressBarView
        android:id="@+id/progressBar"
        android:layout_width="match_parent"
        android:layout_marginHorizontal="30dp"
        android:layout_height="40dp"
        android:layout_gravity="center"
        app:sp_progressWidth="30.0"
        app:sp_dashedWidth="10.0"
        app:sp_stokeWidth="10.0"
        app:sp_bgColor="@color/black"
        app:sp_progressColor="@color/purple_500" />
```

## Now set progress programmatically
```
val progress = findViewById<CustomLineDashedProgressBarView>(R.id.progressBar)
progress.setProgress(70.0f)
```

If you want to animate your progress bar with delay you can achive it by this
```
val progressBar2 = findViewById<CustomLineDashedProgressBarView>(R.id.progressBar2)
progress.setProgress(70.0f)
val animation = ValueAnimator.ofFloat( 0f, 100f);
animation.addUpdateListener {
    progressBar2.setProgress(it.animatedValue as Float)
}
animation.duration = 5000L;
animation.interpolator = LinearInterpolator();
animation.start();
```

<a href="https://paypal.me/shaan8905?country.x=IN&locale.x=en_GB" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

## Happy Coding
