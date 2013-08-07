package cn.wxcs.smartengine.evaluator;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.DataModelBuilder;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
//import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
//import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.wxcs.smartengine.recommender.ItemBasedRecommender;

public class SmartEngineEvaluatorBoolean {
	private static Log logger = LogFactory.getLog(SmartEngineEvaluator.class);
	private static final String EVALUATE_FILE01 = "data/evaluateone";
    protected DataModel dateModel;
    
	public SmartEngineEvaluatorBoolean() throws IOException, TasteException {
		dateModel  = new GenericBooleanPrefDataModel(
				  GenericBooleanPrefDataModel.toDataMap(
				    new FileDataModel(new File(EVALUATE_FILE01))));
	}

	private RecommenderIRStatsEvaluator itemBasedEvaluator;

	public void Run() throws TasteException {
		logger.info("开始测试ItemBasedRecommder");
		itemBasedEvaluator = new GenericRecommenderIRStatsEvaluator();
		
		
		
		
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			
			@Override
			public Recommender buildRecommender(DataModel model) throws TasteException {
				return new ItemBasedRecommender(model);
			}
		};
		
		DataModelBuilder modelBuilder = new DataModelBuilder() {
			  public DataModel buildDataModel(
			      FastByIDMap<PreferenceArray> trainingData) {
			    return new GenericBooleanPrefDataModel(
			      GenericBooleanPrefDataModel.toDataMap(
			        trainingData));
			  }
			};
			
		IRStatistics stats = itemBasedEvaluator.evaluate(recommenderBuilder, modelBuilder,
				dateModel, null,5,
				Double.NEGATIVE_INFINITY, 1.0);
		logger.info("ItemBasedRecommderb 准确率：" + stats.getPrecision());
		logger.info("ItemBasedRecommderb 召回率：" + stats.getRecall());
//		logger.info("ItemBasedRecommder 召回率：" + stats.get);

	}

	public static void main(String[] args) throws IOException, TasteException {
		SmartEngineEvaluatorBoolean evaluator = new SmartEngineEvaluatorBoolean();
		evaluator.Run();
	}
}
