package dao;

import java.util.List;

import entity.Match;
import entity.MatchInfo;
import entity.MatchPlayerAdvanced;
import entity.MatchPlayerBasic;

/**
 * 比赛Dao抽象接口
 * 
 * created by JaneLDQ on 2015年5月18日 下午5:06:44
 */
public interface MatchDao {
	
	/**
	 * 获得某赛季的常规赛比赛基本信息
	 * @param season
	 * @return
	 */
	public List<MatchInfo> getRegularMatchInfoBySeason(String season);
	
	/**
	 * 获得某赛季的季后赛比赛基本信息
	 * @param season
	 * @return
	 */
	public List<MatchInfo> getPlayOffMatchInfoBySeason(String season);
	
	/**
	 * 获得某一时间段的比赛基本信息
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<MatchInfo> getMatchInfoByDate(String begin, String end);
	
	/**
	 * 获得单场比赛中一支球队的球员高阶数据
	 * @param gameid 比赛编号
	 * @param abbr 球队缩写
	 * @return
	 */
	public List<MatchPlayerAdvanced> getMatchPlayerAdvancedByGameIdTeam(String gameid, String abbr);
	
	/**
	 * 获得单场比赛一支球队的球员基本数据
	 * @param gameid 比赛编号
	 * @param abbr 球队缩写
	 * @return
	 */
	public List<MatchPlayerBasic> getMatchPlayerBasicByGameIdTeam(String gameid, String abbr);
	
    /**
     * 插入比赛的完整信息和数据
     * @param list Match的List
     */
    public void insertMatch(List<Match> list);
}