package others.down3;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Monitor {

	public static void main(String[] args) throws Exception {
		

		List<String> locations = new ArrayList<String>();
//		locations.add("chaoyang");
//		locations.add("haidian");
//		locations.add("fengtai");
//		locations.add("shijingshan");
		LianJiaDataHelper dh = new LianJiaDataHelper();
		
		List<String> directions = new ArrayList<String>();
//		directions.add(LianJiaParams.roomDirectionKey_SN);

//		List<String> URLS = LianJiaURLParser.genURL(locations, 0, 500, -1,
//				-1, LianJiaParams.roomCountKey_THREE, null, directions, false,
//				false, false);
		
		URLPool.getInstance().batchPush(LianJiaURLParser.genURL(locations, 0, 500, -1,
				-1, LianJiaParams.roomCountKey_THREE, null, directions, false,
				false, false));
		URLPool.getInstance().batchPush(LianJiaURLParser.genURL(locations, 0, 500, -1,
				-1, LianJiaParams.roomCountKey_FOUR, null, directions, false,
				false, false));
		URLPool.getInstance().batchPush(LianJiaURLParser.genURL(locations, 0, 500, -1,
				-1, LianJiaParams.roomCountKey_TWO, null, directions, false,
				false, false));
		
		List<Document> docs = new ArrayList<Document>();
		
		while(URLPool.getInstance().hasNext()){
			String URL = URLPool.getInstance().popURL();
			try{
				String content = NetUtils.httpGet(URL);
				Document doc = Jsoup.parse(content);
				List<LianJiaHouse> list = LianJiaDocParser.getHouseList(doc);
				for(LianJiaHouse house : list){
					String s = house.getHouseTitle() + "\t" + house.getHouseLocation() + "\t" + house.getHousePrice() + "\t" + house.getPricePerSquare() + "\t" + "\t降价:" + house.isDown();
				}
				
				dh.batchSaveHouse(list);
				
			} catch(Exception e){
				URLPool.getInstance().pushURL(URL);
				e.printStackTrace();
			}
		}

	}

}
