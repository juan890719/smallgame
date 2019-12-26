package com.michelle.smallgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_LOGIC = 110;
    boolean logon = false;
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameView = findViewById(R.id.gameView);
        findViewById(R.id.up).setOnClickListener(this);
        findViewById(R.id.down).setOnClickListener(this);
        findViewById(R.id.left).setOnClickListener(this);
        findViewById(R.id.right).setOnClickListener(this);

        if(!logon){
            Intent game = new Intent(this,GameActivity.class);
            startActivityForResult(game,REQUEST_CODE_LOGIC);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_LOGIC){
            if (resultCode != RESULT_OK){
                finish();
            }
            else{
                logon = true;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:
                gameView.setPosY(gameView.getPosY() - 100);
                gameView.invalidate();
                break;
            case R.id.down:
                gameView.setPosY(gameView.getPosY() + 100);
                gameView.invalidate();
                break;
            case R.id.left:
                gameView.setPosX(gameView.getPosX() - 100);
                gameView.invalidate();
                break;
            case R.id.right:
                gameView.setPosX(gameView.getPosX() + 100);
                gameView.invalidate();
                break;
        }
    }
}
