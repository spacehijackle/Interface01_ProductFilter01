package filter;

import data.Product;

/**
 * 指定価格以下の商品フィルター
 *
 * @author t.yoshida
 */
public class PriceBelowFilter implements ProductFilter
{
	// 指定価格（上限価格）
	private int _price;

	/**
	 * 指定価格以下の商品フィルターを生成する。
	 *
	 * @param price 指定価格
	 */
	public PriceBelowFilter(int price)
	{
		_price = price;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return true: 商品価格が指定価格以下の場合
	 */
	@Override
	public boolean isMatches(Product target)
	{
		return (target.getPrice() <= _price);
	}
}
