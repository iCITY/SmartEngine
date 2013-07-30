package cn.wxcs.smartengine.recommender;

import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.common.TasteException;

public class ItemBasedRecommender extends BaseRecommender {

	public ItemBasedRecommender() throws TasteException { 
		Init();
	}
	
	public ItemBasedRecommender(DataModel model) throws TasteException {
		this.setDataModel(model);
		Init();
	}
	
	private void Init() throws TasteException{
		this.setSimilarity(new UncenteredCosineSimilarity(this.getDataModel()));
		this.setRecommender(new GenericItemBasedRecommender(this.getDataModel(),this.getSimilarity()));
	}

}
