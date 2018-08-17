package filter;

import data.Product;

/**
 * 指定価格の商品フィルター
 *
 * @author t.yoshida
 */
public class FixedPriceFilter implements ProductFilter
{
	// 指定価格
	private int _price;

	/**
	 * 指定価格の商品フィルターを生成する。
	 *
	 * @param price 指定価格
	 */
	public FixedPriceFilter(int price)
	{
		_price = price;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return true: 商品価格が指定価格と同じ場合
	 */
	@Override
	public boolean isMatches(Product target)
	{
		return (target.getPrice() == _price);
	}
}
