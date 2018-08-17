package filter;

import data.Product;

/**
 * 指定価格範囲の商品フィルター
 *
 * @author t.yoshida
 */
public class PriceBetweenFilter implements ProductFilter
{
	// 下限価格
	private int _lowest;

	// 上限価格
	private int _highest;

	/**
	 * 指定価格範囲の商品フィルターを生成する。
	 *
	 * @param lowest 下限価格
	 * @param highest 上限価格
	 */
	public PriceBetweenFilter(int lowest, int highest)
	{
		if(lowest > highest)
		{
			throw new IllegalArgumentException("Price is upside down.");
		}

		_lowest = lowest;
		_highest = highest;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return true: 商品価格が指定価格範囲内の場合
	 */
	@Override
	public boolean isMatches(Product target)
	{
		int price = target.getPrice();
		return (price >= _lowest && price <= _highest);
	}
}
