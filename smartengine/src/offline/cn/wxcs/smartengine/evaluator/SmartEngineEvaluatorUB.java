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


import cn.wxcs.smartengine.recommender.UserBasedRecommender;

public class SmartEngineEvaluatorUB {
	private static Log logger = LogFactory.getLog(SmartEngineEvaluator.class);
	private static final String EVALUATE_FILE = "data/evaluate";
    protected DataModel dateModel;
    
	public SmartEngineEvaluatorUB() throws IOException {
		dateModel = new FileDataModel(new File(EVALUATE_FILE));
	}

	private RecommenderIRStatsEvaluator userbasedEvaluator;

	public void Run() throws TasteException {
		logger.info("开始测试userbasedRecommder");
		userbasedEvaluator = new GenericRecommenderIRStatsEvaluator();
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			@Override
			public Recommender buildRecommender(DataModel model) throws TasteException {
				return new UserBasedRecommender(model);
			}
		};
		IRStatistics stats = userbasedEvaluator.evaluate(recommenderBuilder, null,
				dateModel, null,30,
				Double.NEGATIVE_INFINITY, 1);
		logger.info("userbasedRecommder 准确率：" + stats.getPrecision());
		logger.info("userbasedRecommder 召回率：" + stats.getRecall());
		logger.info("userbasedRecommder F1: "+stats.getF1Measure());
		//		logger.info("userbasedRecommder 召回率：" + stats.get);

	}

	public static void main(String[] args) throws IOException, TasteException {
		SmartEngineEvaluatorUB evaluator = new SmartEngineEvaluatorUB();
		evaluator.Run();
	}
}
