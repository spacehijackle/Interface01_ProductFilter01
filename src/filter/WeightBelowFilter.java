package filter;

import data.Product;

/**
 * 指定重量(g)以下の商品フィルター
 *
 * @author t.yoshida
 */
public class WeightBelowFilter implements ProductFilter
{
	// 指定重量(g)
	private int _weight;

	/**
	 * 指定重量(g)以下の商品フィルターを生成する。
	 *
	 * @param weight 指定重量(g)
	 */
	public WeightBelowFilter(int weight)
	{
		_weight = weight;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return true: 商品重量が指定重量以下の場合
	 */
	@Override
	public boolean isMatches(Product target)
	{
		return (target.getWeight() <= _weight);
	}
}
