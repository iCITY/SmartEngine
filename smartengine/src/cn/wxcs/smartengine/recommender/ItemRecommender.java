package cn.wxcs.smartengine.recommender;

import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.common.TasteException;

public class ItemRecommender extends BaseRecommender {

	public ItemRecommender() throws TasteException { 
		ItemSimilarity similarity = new UncenteredCosineSimilarity(this.getDataModel());
		this.setRecommender(new GenericItemBasedRecommender(this.getDataModel(), similarity));
	}

}
