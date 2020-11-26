public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMult, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons= new Button[10];
    Integer[] numBtnIds = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMult = (Button) findViewById(R.id.BtnMult);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult = (TextView) findViewById(R.id.TextResult);

        //Listener
        btnAdd.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과: " +result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과: " +result.toString());
                return false;
            }
        });
        btnMult.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과: " +result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과: " +result.toString());
                return false;
            }
        });
        for (i=0; i<numBtnIds.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIds[i]);
        }
        for (i=0; i<numBtnIds.length; i++) {
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하십시오", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
