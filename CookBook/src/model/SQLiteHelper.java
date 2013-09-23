package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLDataException;
import java.util.ArrayList;

import android.R.array;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_PATH="/data/data/com.example.cookbok/databases/";
	private static final String DATABASE_NAME="cookbook.sqlite";
	private static final int DATABASE_VERSION=1;
	
	private SQLiteDatabase myDataBase;
	private final Context myContext;
	
	//bang mon an
	private static final String M_A_TABLE_NAME="MonAn";
	private static final String M_ID="_mid";
	private static final String TENM_A="ten";
	private static final String LIDM_A="lid";
	private static final String ANH="anh";
	private static final String MEOVAT="meovat";
	private static final String YEU_THICH="yeuthich";
	private static final String NGUYEBLIEU="nguyelieu";
	private static final String CACHLAM="cachlam";
	private static final String THID_M_A="thid";
	
	//bang muc luc
	private static final String M_L_TABLE_NAME="MucLuc";
	private static final String MLID="_mlid";
	private static final String TENM_L="ten";
	private static final String ANHM_L="anh";
	
	//bang loai
	private static final String L_TABLE_NAME="MucLuc";
	private static final String LID="_lid";
	private static final String TENL="ten";
	private static final String ANHL="anh";
	private static final String M_L_ID_L="mlid";
	
	//bang thuc don
	private static final String T_D_TABLE_NAME="ThucDon";
	private static final String	THID="_thid";
	private static final String TEN_TH="ten";
	private static final String GHICHU="ghichu";
	private static final String NGAYTAO="ngaytao";
	private static final String NGAYTHUCHIEN="ngaythuchien";
	
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		myContext= context;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}
	
	public void openDatabase() throws SQLDataException{
		//open database
		String myPath = DATABASE_PATH + DATABASE_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		System.out.println("mo duoc database");
	}
	
	@Override
	public synchronized void close() {
		if(myDataBase != null)
		myDataBase.close();
 
		super.close();
		
	}
	
	//kiem tra xem da co database chua
	 private boolean checkDataBase(){ 
		 SQLiteDatabase checkDB = null;
		  
		 try{
			 String myPath = DATABASE_PATH + DATABASE_NAME;
			 checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		 }catch(SQLiteException e){
			 //database chua ton tai
		 }
		 
		 if(checkDB != null)
			 checkDB.close();
		  System.out.println("check database thanh cong");
		 return checkDB != null ? true : false;
	
	 }
	 // coppy data tu assets sang data
	 private void copyDataBase() throws IOException{
		 
		 	//mo db trong thu muc assets nhu mot input stream
			InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
			 
			//duong dan den db se tao
			String outFileName = DATABASE_PATH + DATABASE_NAME;
			 
			//mo db giong nhu mot output stream
			OutputStream myOutput = new FileOutputStream(outFileName);
			 
			//truyen du lieu tu inputfile sang outputfile
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer))>0)
			{
				myOutput.write(buffer, 0, length);
			}
			 
			//Dong luon
			myOutput.flush();
			myOutput.close();
			myInput.close();
			System.out.println("copy databse thanh cong");
			 
	}
	public void createDataBase() throws IOException{
		boolean dbExist = checkDataBase(); //kiem tra db
			  
		if(dbExist){
			 	//khong lam gi ca, database da co roi
		}
		else{
			this.getReadableDatabase();
			try {
				copyDataBase(); //chep du lieu
			} 
			catch (IOException e) {
			 		throw new Error("Error copying database");
			 }
			}
		 }  

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	//lay mon an
	public MonAn getMonAn(int mid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c= sd.rawQuery("select * from "+M_A_TABLE_NAME+" where "+M_ID+" = "+ mid, null);
		c.moveToNext();
		
		MonAn result= new MonAn();
		result.setMid(c.getInt(c.getColumnIndex(M_ID)));
		result.setTen(c.getString(c.getColumnIndex(TENM_A)));
		result.setLid(c.getInt(c.getColumnIndex(LIDM_A)));
		result.setCachLam(c.getString(c.getColumnIndex(CACHLAM)));
		result.setNguyenLieu(c.getString(c.getColumnIndex(NGUYEBLIEU)));
		result.setMeoVat(c.getString(c.getColumnIndex(MEOVAT)));
		result.setThid(c.getInt(c.getColumnIndex(THID_M_A)));
		result.setYeuthich(c.getInt(c.getColumnIndex(YEU_THICH)));
		result.setAnh(c.getString(c.getColumnIndex(ANH)));
		return result;
	}

	//lay mon an theo loai
	public ArrayList<MonAn> getAllMonAnByLoai(int lid){
		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<MonAn> list= new ArrayList<MonAn>();
		Cursor c= sd.rawQuery("select * from "+M_A_TABLE_NAME+" where "+ LIDM_A+" = " +lid ,null);
		
		c.moveToLast();
		c.moveToNext();
		
		while(c.moveToPrevious()){
			MonAn result= new MonAn();
			result.setMid(c.getInt(c.getColumnIndex(M_ID)));
			result.setTen(c.getString(c.getColumnIndex(TENM_A)));
			//result.setLid(c.getInt(c.getColumnIndex(LIDM_A)));
			//result.setCachLam(c.getString(c.getColumnIndex(CACHLAM)));
			//result.setNguyenLieu(c.getString(c.getColumnIndex(NGUYEBLIEU)));
			//result.setMeoVat(c.getString(c.getColumnIndex(MEOVAT)));
			//result.setThid(c.getInt(c.getColumnIndex(THID_M_A)));
			//result.setYeuthich(c.getInt(c.getColumnIndex(YEU_THICH)));
			result.setAnh(c.getString(c.getColumnIndex(ANH)));
			list.add(result);
		}
		System.out.println("danh dach cham ngon cua cid= "+ lid +" la "+ list.toString());
		return list;
	}
	
	
	public ArrayList<MonAn> getMonAnYeuThich(){
		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<MonAn> list= new ArrayList<MonAn>();
		Cursor c= sd.rawQuery("select * from "+M_A_TABLE_NAME+" where "+ YEU_THICH + " = " + 1,null);
		
		c.moveToLast();
		c.moveToNext();
		
		while(c.moveToPrevious()){
			MonAn result= new MonAn();
			result.setMid(c.getInt(c.getColumnIndex(M_ID)));
			result.setTen(c.getString(c.getColumnIndex(TENM_A)));
			//result.setLid(c.getInt(c.getColumnIndex(LIDM_A)));
			//result.setCachLam(c.getString(c.getColumnIndex(CACHLAM)));
			//result.setNguyenLieu(c.getString(c.getColumnIndex(NGUYEBLIEU)));
			//result.setMeoVat(c.getString(c.getColumnIndex(MEOVAT)));
			//result.setThid(c.getInt(c.getColumnIndex(THID_M_A)));
			//result.setYeuthich(c.getInt(c.getColumnIndex(YEU_THICH)));
			result.setAnh(c.getString(c.getColumnIndex(ANH)));
			list.add(result);
		}
		System.out.println("danh dach cham ngon yeu thich" +" la "+ list.toString());
		return list;
	}
	
	
	
	public void updateMonAn(MonAn ma ){
		SQLiteDatabase sd= getWritableDatabase();
		
		ContentValues values =new ContentValues();
		
		values.put(YEU_THICH, ma.isYeuthich());
		sd.update(M_A_TABLE_NAME, values, M_ID+" = "+ ma.getMid(), null);
		System.out.println("update thanh cong");
	}

	
	
	
	//lay muc luc 
	public MucLuc getMucLuc(int mlid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c = sd.rawQuery("select * from "+M_L_TABLE_NAME+" where "+MLID+" = "+ mlid, null);
		c.moveToNext();
		
		MucLuc result =new MucLuc();
		result.setMlid(c.getInt(c.getColumnIndex(MLID)));
		result.setTen(c.getString(c.getColumnIndex(TENM_L)));
		result.setAnh(c.getString(c.getColumnIndex(ANHM_L)));
		System.out.println("get content thanh cong "+ result.toString());
		return result;
	}
	
	public ArrayList<MucLuc>  getTatCaMucLuc(){
		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<MucLuc> list = new ArrayList<MucLuc>();
		System.out.println("get all contennt");
		Cursor c = sd.rawQuery("select * from "+MLID, null);
		System.out.println("thuc hien truy van thanh cong");
		while(c.moveToNext()){
			MucLuc result =new MucLuc();
			result.setMlid(c.getInt(c.getColumnIndex(MLID)));
			result.setTen(c.getString(c.getColumnIndex(TENM_L)));
			result.setAnh(c.getString(c.getColumnIndex(ANHM_L)));			
			list.add(result);
		}
		return list;
	}
	
	//lay loai cac mon an
	public Loai getLoai(int lid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c = sd.rawQuery("select * from "+L_TABLE_NAME+" where "+ LID +" = "+ lid, null);
		c.moveToNext();
		
		Loai result =new Loai();
		result.setLid(c.getInt(c.getColumnIndex(LID)));
		result.setTen(c.getString(c.getColumnIndex(TENL)));
		result.setAnh(c.getString(c.getColumnIndex(ANHL)));
		result.setMlid(c.getInt(c.getColumnIndex(M_L_ID_L)));
		System.out.println("get content thanh cong "+ result.toString());
		return result;
	}
	
	//lay loai thuoc muc luc
	public ArrayList<Loai> getLoaiByMucLuc(int mlid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c = sd.rawQuery("select * from "+L_TABLE_NAME+" where "+ M_L_ID_L +" = "+ mlid, null);
		c.moveToNext();
		ArrayList<Loai> list = new ArrayList<Loai>();
		while(c.moveToNext()){
			Loai result =new Loai();
			result.setLid(c.getInt(c.getColumnIndex(LID)));
			result.setTen(c.getString(c.getColumnIndex(TENL)));
			result.setAnh(c.getString(c.getColumnIndex(ANHL)));
			result.setMlid(c.getInt(c.getColumnIndex(M_L_ID_L)));
			list.add(result);
		}
		return list;
	}
	
	//lay danh sach lay mon an thuoc thuc don
	public ArrayList<MonAn> getMonAnbyThucDon(int thid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c= sd.rawQuery("select * from "+M_A_TABLE_NAME+" where "+ THID_M_A +" = "+ thid, null);
		c.moveToLast();
		c.moveToNext();
		ArrayList<MonAn> list =new ArrayList<MonAn>(); 
		while(c.moveToPrevious()){
			MonAn result= new MonAn();
			result.setMid(c.getInt(c.getColumnIndex(M_ID)));
			result.setTen(c.getString(c.getColumnIndex(TENM_A)));
			//result.setLid(c.getInt(c.getColumnIndex(LIDM_A)));
			//result.setCachLam(c.getString(c.getColumnIndex(CACHLAM)));
			//result.setNguyenLieu(c.getString(c.getColumnIndex(NGUYEBLIEU)));
			//result.setMeoVat(c.getString(c.getColumnIndex(MEOVAT)));
			//result.setThid(c.getInt(c.getColumnIndex(THID_M_A)));
			//result.setYeuthich(c.getInt(c.getColumnIndex(YEU_THICH)));
			result.setAnh(c.getString(c.getColumnIndex(ANH)));
			list.add(result);
		}
		System.out.println("danh dach cham ngon cua cid= "+ thid +" la "+ list.toString());
		return list;
	}
	
	
	//lay thuc don
	public ThucDon getThucDon(int thid){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c= sd.rawQuery("select * from "+T_D_TABLE_NAME+" where "+ THID_M_A +" = "+ thid, null);
		c.moveToNext();
		ThucDon result = new ThucDon();
		result.setThid(c.getInt(c.getColumnIndex(THID)));
		result.setGhiChu(c.getString(c.getColumnIndex(GHICHU)));
		result.setNgayTao(c.getString(c.getColumnIndex(NGAYTAO)));
		result.setNgayThucHien(c.getString(c.getColumnIndex(NGAYTHUCHIEN)));
		result.setTen(c.getString(c.getColumnIndex(TEN_TH)));
		result.setDsMonAn(getMonAnbyThucDon(thid));
		
		return result;
	}
	
	//lay ten tat ca cac thuc don
	public ArrayList<String> getAllTenThucDon(){
		SQLiteDatabase sd= getWritableDatabase();
		Cursor c= sd.rawQuery("select * from "+T_D_TABLE_NAME, null);
		c.moveToLast();
		c.moveToNext();
		ArrayList<String> list =new ArrayList<String>();
		while(c.moveToPrevious()){
			list.add(c.getString(c.getColumnIndex(TEN_TH)));
		}
		return list;
	}
	
	//get numbera
	/*public int maxIdProducts(){
		
 		SQLiteDatabase sd = getWritableDatabase();
 		
 		Cursor c = sd.rawQuery("select max("+CHID+") from "+CH_TABLE_NAME, null);
 		c.moveToFirst();
 		if(!c.isNull(0)){
 			
 			return c.getInt(0);
 		}
 		return 0;
 		
 	}*/
	
}
