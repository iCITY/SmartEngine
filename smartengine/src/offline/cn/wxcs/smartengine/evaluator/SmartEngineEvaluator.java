package cn.wxcs.smartengine.evaluator;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
//import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
//import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.wxcs.smartengine.recommender.ItemBasedRecommender;

public class SmartEngineEvaluator {
	private static Log logger = LogFactory.getLog(SmartEngineEvaluator.class);
	private static final String EVALUATE_FILE = "data/evaluate";
    protected DataModel dateModel;
    
	public SmartEngineEvaluator() throws IOException {
		dateModel = new FileDataModel(new File(EVALUATE_FILE));
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
		IRStatistics stats = itemBasedEvaluator.evaluate(recommenderBuilder, null,
				dateModel, null, 2,
				0.7, 1.0);
		logger.info("ItemBasedRecommder 准确率：" + stats.getPrecision());
		logger.info("ItemBasedRecommder 召回率：" + stats.getRecall());
				int dtest =1;
				int dtestw =3;

	}

	public static void main(String[] args) throws IOException, TasteException {
		SmartEngineEvaluator evaluator = new SmartEngineEvaluator();
		evaluator.Run();
	}
}
