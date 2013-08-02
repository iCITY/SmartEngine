package cn.wxcs.smartengine.offline.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;

import cn.wxcs.smartengine.recommender.ItemBasedRecommender;

public class ItemBasedRecommenderTest {
	private static Log logger = LogFactory.getLog(ItemBasedRecommenderTest.class);
	
	private static final String TEST_FILE = "test/test_data";
	private static final long TEST_USER_ID = 10010145419l;
	private static final long TEST_ITEM_ID = 1l;
	private static final int TEST_RECOMMEND_COUNT = 50;
	
	protected DataModel dateModel;
	protected ItemBasedRecommender recommender;
	
	@Test
	public void testRecommend() throws IOException, TasteException {
		dateModel = new FileDataModel(new File(TEST_FILE));
		recommender = new ItemBasedRecommender(dateModel);
		List<RecommendedItem> items = recommender.recommend(TEST_USER_ID, TEST_RECOMMEND_COUNT);
		
		logger.info(items.size());
		for(RecommendedItem item : items){
			logger.info("item: " + item.getItemID() + " value:" + item.getValue());
		}
		assertNotNull(items);
		
	}

}
