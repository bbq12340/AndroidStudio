public class MainActivity extends AppCompatActivity  {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;
    static float scaleX=1, scaleY=1;
    static float angle=0;
    static float color=1;
    static float satur=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();

    }

    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX+0.2f;
                scaleY = scaleY+0.2f;
                graphicView.invalidate();
            }
        });
        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX-0.2f;
                scaleY = scaleY-0.2f;
                graphicView.invalidate();
            }
        }));
        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle+20;
                graphicView.invalidate();
            }
        });
        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });
        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });
        ibGray = (ImageButton) findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (satur == 0) satur = 1;
                else satur = 0;
                graphicView.invalidate();
            }
        });

    }

    public static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int cenX = this.getWidth()/2;
            int cenY = this.getHeight()/2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);
            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0,
                                0, color, 0, 0, 0,
                                0, 0, color, 0, 0,
                                0, 0, 0, 1, 0};
            ColorMatrix cm =new ColorMatrix(array);
            if (satur==0) cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth())/2;
            int picY = (this.getHeight() - picture.getHeight())/2;
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}