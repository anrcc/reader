package cc.anr.tools;

import android.graphics.Paint;

public class LayoutUtil {

	
	private final static char SPACE_CHAR = ' ';	// \u0020
	private final static char SBC_CASE_SPACE_CHAR = '　';	// \u3000
	
	public static void layoutTextJustified (CharSequence text, int maxWidth, Paint paint, float startX, float constantY, float[] positions) {
		int endIndex = text.length();
		float actualWidth = paint.measureText(text, 0, text.length());
		int glyphRunCount = 0;
		boolean withinGlyphRun = false;
		for (int i = 0; i < endIndex; ++i) {
			char ch = text.charAt(i);
			boolean prevWithinGlyphRun = withinGlyphRun;
			withinGlyphRun = ch == SBC_CASE_SPACE_CHAR || (ch != SPACE_CHAR && ch <= 0x7f);
			
			if(i > 0 && (!withinGlyphRun || (withinGlyphRun && !prevWithinGlyphRun))) {
				++glyphRunCount;
			}
		}
		
		float kerning = (maxWidth - actualWidth) / glyphRunCount;
		
		float previousPosX = startX;
		withinGlyphRun = false;
		for (int i = 0, j = 0; i < endIndex; ++i, j+=2) {
			char ch = text.charAt(i);
			boolean prevWithinGlyphRun = withinGlyphRun;
			withinGlyphRun = ch == SBC_CASE_SPACE_CHAR || (ch != SPACE_CHAR && ch <= 0x7f);
			
			if(i > 0 && (!withinGlyphRun || (withinGlyphRun && !prevWithinGlyphRun))) {
				previousPosX += kerning;
			}
			
			positions[j] = previousPosX;
			positions[j+1] = constantY;
			
			previousPosX += paint.measureText(text, i, i + 1);
		}
	}
}
