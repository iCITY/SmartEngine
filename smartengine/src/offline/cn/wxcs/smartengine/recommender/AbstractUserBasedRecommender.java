
/**
 * 
 */
package cn.wxcs.smartengine.recommender;

import java.util.Collection;
import java.util.List;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.IDRescorer;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author chenlianghui
 * 
 */
public class AbstractUserBasedRecommender implements Recommender {

	/**
	 * 
	 */
	public AbstractUserBasedRecommender() {
		
	}

	public AbstractUserBasedRecommender(DataModel dataModel) {
		this.setDataModel(dataModel);
	}
	
	private Recommender recommender;
	private DataModel dataModel;	
	private UserSimilarity similarity;
	private UserNeighborhood neighborhood;
	
	
	public UserNeighborhood getUserNeighborhood(){
		return neighborhood;
	}
	public void setUserNeighborhood (UserNeighborhood  neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public UserSimilarity getSimilarity() {
		return similarity;
	}
	public void setSimilarity(UserSimilarity similarity) {
		this.similarity = similarity;
	}	
	
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public Recommender getRecommender() {
		return recommender;
	}

	public void setRecommender(Recommender recommender) {
		this.recommender = recommender;
	}

	@Override
	public List<RecommendedItem> recommend(long userID, int howMany)
			throws TasteException {
		return recommender.recommend(userID, howMany);
	}

	@Override
	public List<RecommendedItem> recommend(long userID, int howMany,
			IDRescorer rescorer) throws TasteException {
		return recommender.recommend(userID, howMany, rescorer);
	}

	@Override
	public float estimatePreference(long userID, long itemID)
			throws TasteException {
		return recommender.estimatePreference(userID, itemID);
	}

	@Override
	public void setPreference(long userID, long itemID, float value)
			throws TasteException {
		recommender.setPreference(userID, itemID, value);
	}

	@Override
	public void removePreference(long userID, long itemID)
			throws TasteException {
		recommender.removePreference(userID, itemID);
	}

	@Override
	public DataModel getDataModel() {
		return dataModel;
		//return recommender.getDataModel();
	}

	@Override
	public void refresh(Collection<Refreshable> alreadyRefreshed) {
		recommender.refresh(alreadyRefreshed);
	}

	@Override
	public String toString() {
		return "Recommender[recommender:" + recommender + ']';
	}

}
