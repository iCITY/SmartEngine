package cn.wxcs.smartengine.recommender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;

public class UserBasedRecommender  extends AbstractUserBasedRecommender {
	public UserBasedRecommender() throws TasteException { 
		Init();
	}
	
	public UserBasedRecommender(DataModel model) throws TasteException {
		this.setDataModel(model);
		Init();
	}
	
	private void Init() throws TasteException{
		this.setSimilarity(new TanimotoCoefficientSimilarity (this.getDataModel()));
		this.setUserNeighborhood(new NearestNUserNeighborhood(14,this.getSimilarity(),this.getDataModel()));
		this.setRecommender(new GenericUserBasedRecommender(this.getDataModel(),this.getUserNeighborhood(),this.getSimilarity()));
		
	}
}
