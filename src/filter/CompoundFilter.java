package filter;

import data.Product;

/**
 * 複合商品フィルター
 *
 * @author t.yoshida
 */
public class CompoundFilter implements ProductFilter
{
	// フィルター配列
	private ProductFilter[] _filters;

	/**
	 * 複合商品フィルターを生成する。
	 *
	 * @param filters 可変数の商品フィルター
	 */
	public CompoundFilter(ProductFilter... filters)
	{
		_filters = filters;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return true: 複数の商品フィルター全てで合致する場合
	 */
	@Override
	public boolean isMatches(Product target)
	{
		// 複数の商品フィルターを「かつ条件」で組み合わせる
		for(ProductFilter filter : _filters)
		{
			if(!filter.isMatches(target))
			{
				// フィルター条件にひとつでも合致しなければ false を返す。
				return false;
			}
		}

		return true;
	}
}
