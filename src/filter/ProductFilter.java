package filter;

import data.Product;

/**
 * 商品絞り込みフィルター
 *
 * @author t.yoshida
 */
public interface ProductFilter
{
	/**
	 * 指定された商品を絞り込みの結果、残すか否か判定する。
	 *
	 * @param target 判定する対象商品
	 * @return true: 絞り込みで残す場合
	 */
	boolean isMatches(Product target);
}
