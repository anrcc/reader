package cc.anr.aviews;

import cc.anr.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class ReadingBoard extends View{

	private static String str="七月第一次遇见安生的时候，是十三岁的时候。新生报到会上，一大堆排着队的陌生同学。\n" +
			"是炎热的秋日午后，明亮的阳光照得人眼睛发花。突然一个女孩转过脸来对七月说，我们去操场转转吧。\n" +
			"女孩的微笑很快乐。七月莫名其妙地就跟着她跑了。很久以后，七月对家明说，她和安生之间，她是一次被选择的结果。\n" +
			"只是她心甘情愿。虽然对这种心甘情愿，她并不能做出更多的解释。我的名字叫七月。\n" +
			"当安生问她的时候，七月对她说，那是她出生的月份。那一年的夏天非常炎热。对母亲来说，酷暑和难产是一次劫难。\n" +
			"可是她给七月取了一个平淡的名字。就像世间的很多事物。人们并无方法从它寂静的表象上猜测到暗涌。\n" +
			"比如一个人和另一个人的相遇。或者他们的离别。而安生，她说，她仅仅只证实到自己的生命。\n" +
			"她摊开七月的手心，用她的指尖涂下简单的笔画，脸上带着自嘲的微笑。那是她们初次相见的景象。\n" +
			"秋日午后的阳光在安生的手背上跳跃。像一群活泼的小鸟振动着翅膀飞远。那时候她还没有告诉七月，她是个没有父亲的孩子。她的母亲因为爱一个男人，为他生下孩子，却注定一生要为他守口如瓶。七月也没有告诉安生，安生的名字在那一刻已在她的手心里留下无痕的烙印。\n" +
			"因为安生，夏天成为一个充满幻觉和迷惘的季节。\n" +
			"十三岁到十六岁。那是七月和安生如影相随的三年。\n" +
			"有时候七月是安生的影子。有时候安生是七月的影子。一起做作业。跑到商店去看内衣。周末的时候安生去七月家里吃饭，留宿。\n" +
			"走在路上都要手拉着手。\n" +
			"七月第一次到安生的家里去玩的时候，感觉到安生很寂寞。\n" +
			"安生独自住一大套公寓。她的母亲常年在国外。雇了一个保姆和安生一起生活。安生的房间布置得像公主的宫殿，有满满衣橱的漂亮衣服。可是因为没有人，显得很寒冷。\n" +
			"七月坐了一会就感到身上发抖。安生把空调和所有的灯都打开了。她说，她一个人的时候常常就这样。然后她带七月去看她母亲养的一缸热带鱼。\n" +
			"安生丢饲料下去的时候，美丽的小鱼就像一条条斑斓的绸缎在抖动。\n" +
			"安生说，这里的水是温暖的。可是有些鱼，它们会成群地穿越寒冷的海洋，迁徙到辽阔的远方。因为那里有他们的家。\n" +
			"安生那时候的脸上有一种很阴郁的神情。\n" +
			"在学校里，安生是个让老师头疼的孩子。言辞尖锐，桀骜不驯，常常因为和老师抢白而被逐出教室。少年的安生独自坐在教室外的空地上。\n" +
			"阳光洒在她倔强的脸上。七月偷偷地从书包里抽出小说和话梅，扔给窗外的安生。然后她知道安生会跑到她的窝去看书。\n" +
			"那是她们在开学的那个下午跑到操场上找到的大树。很老的樟树，树叶会散发出刺鼻的清香。\n" +
			"安生踢掉鞋子，用几分钟时间就能爬到树杈的最高处。她像一只鸟一样躲在树丛里。晃动着两条赤裸的小腿，眺望操场里空荡荡的草地和远方。\n" +
			"七月问她能看到什么。她说，有绿色的小河，有开满金黄雏菊的田野，还有石头桥。一条很长很长的铁轨，不知道通向哪里。\n" +
			"然后她伸手给她，高声地叫着，七月，来啊。七月仰着头，绞扭着自己的手指，又兴奋又恐惧。可是她始终没有跟安生学会爬树。\n" +
			"终于有一天，她们决定去看看那条铁路。她们走了很久很久。一直到暮色迷离，还没有兜到那片田野里面。半路突然下起大雨。\n" +
			"两个女孩躲进了路边的破茅草屋里。七月说，我们还是回家吧。安生说，我肯定再走一会就到了。我曾发誓一定要到这段每天都能看到的铁路上走走。\n" +
			"于是大雨中，两个女孩撑着一把伞向前方飞跑。裙子和鞋子都湿透了。终于看到了长长的铁轨。在暮色和雨雾中蔓延到苍茫的远方。而田野里的雏菊早已经凋谢。\n" +
			"安生的头发和脸上都是雨水。她说，七月，总有一天，我会摆脱掉所有的束缚，去更远的地方。\n" +
			"七月低下头有些难过。她说，那我呢。安生说，你和我一起走。 ";
	
	static StringBuffer txtContent=new StringBuffer(str);
	
	Rect rect=new Rect();
	private final static String NEW_LINE_STR = "\n";
	public static final String TEXT_STR = "中";
	
	private int mRenderWidth;
	private int mRenderHeight;
	
	
	private Bitmap mBackupPageBitmap;
	private Bitmap mMainPageBitmap;
	private Canvas mDrawableCanvas;
	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//	private float mLayoutPositions[] = new float[4096];
	
	public ReadingBoard(Context context, AttributeSet attrs) {
		super(context, attrs);
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		mRenderWidth=display.getWidth();
		mRenderHeight=display.getHeight();
		mBackupPageBitmap = Bitmap.createBitmap(480, 800, Config.RGB_565);
		mMainPageBitmap = Bitmap.createBitmap(mRenderWidth, mRenderHeight, Config.RGB_565);
		mDrawableCanvas=new Canvas();
	}

	
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawPage(mDrawableCanvas);
		canvas.drawBitmap(mMainPageBitmap, 0, 0, null);
		canvas.drawBitmap(mMainPageBitmap, 100, 0, null);
	}
	
	public void drawPage(Canvas canvas){
		//canvas.setBitmap(mBackupPageBitmap);
		//canvas.drawBitmap(mMainPageBitmap, 0, 0, null);
		canvas.setBitmap(mMainPageBitmap);
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		
		getDrawingRect(rect);
		Resources res = getResources();
		Drawable bgDrawable = res.getDrawable(R.drawable.reading_bg_1);
		bgDrawable.setBounds(rect);
		bgDrawable.draw(canvas);
		
		paint.setTextSize(24);
		paint.getTextBounds(TEXT_STR, 0, TEXT_STR.length(), rect);
		int height=0;
		int space=25;
		StringBuilder sb=new StringBuilder();
		while(getNextLine(sb)){
			canvas.drawText(sb.toString(), 0, height, paint);
			height+=getTextHeight()+space;
			sb.delete(0, sb.length());
			System.out.println(sb);
		}
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
	}

	
	int mCharCountOfPage=0; 
	int index = 0;
	int mNewlineIndex=0;
	int mEndCharIndex=0;
	public boolean getNextLine(StringBuilder sb ){
		boolean flag=true;
		index=mCharCountOfPage;
		if (index == mNewlineIndex) { 
			if(mNewlineIndex>0){
				mNewlineIndex++;
			}
			mNewlineIndex = txtContent.indexOf(NEW_LINE_STR, mNewlineIndex);
			if(mNewlineIndex==-1){
				mEndCharIndex=txtContent.length();
				flag=false;
			}else{
				mEndCharIndex=mNewlineIndex;
			}
		}
		int charCount = paint.breakText(txtContent, index, mEndCharIndex, true, mRenderWidth, null);
		sb.append(txtContent, index, index + charCount);
		mCharCountOfPage+=charCount;
		return flag;
	}
	
	
	
	public int getTextHeight(){
		int mTextHeight = rect.bottom - rect.top;
		return mTextHeight;
	}
	
}
