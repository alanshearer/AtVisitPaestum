package com.visitpaestum;

import java.lang.reflect.Method;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class CustomTableRow extends TableRow {

	TextView textview;

	public CustomTableRow(Context context, final String StringToShow) {
		super(context);

		setClickable(true);

		setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		textview = new TextView(getContext());
		textview.setText(StringToShow);
		textview.setTextSize(30f);
		// textview.getTextColors(R.color.)
		textview.setTextColor(Color.YELLOW);
		addView(textview);
	}
	
	public void SetCustomTableRowListener(final Method method, final Object receiver){
		
		this.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					System.out.println("STAMPATO");
					Object[] parameters = new Object[1];
					parameters[0] = textview.getText().toString();
					method.invoke(receiver, parameters);
					System.out.println("STAMPATO2");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
