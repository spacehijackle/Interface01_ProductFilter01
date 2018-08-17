package main;

import java.util.ArrayList;
import java.util.List;

import data.Product;
import filter.CompoundFilter;
import filter.FixedPriceFilter;
import filter.PriceBelowFilter;
import filter.PriceBetweenFilter;
import filter.ProductFilter;
import filter.WeightBelowFilter;

/**
 * 商品を絞り込むプログラム例
 *
 * @author t.yoshida
 */
public class Startup
{
	public static void main(String[] args)
	{
		// オリジナル商品リスト
		List<Product> products = createProducts();
		showProducts("オリジナル商品リスト", products);

		// 絞り込み後商品リスト定義
		List<Product> filteredProducts;

		// 100円ポッキリの商品に絞り込み
		filteredProducts = applyFilter(products, new FixedPriceFilter(100));
		showProducts("100円ポッキリ！", filteredProducts);

		// ワンコインで買える商品に絞り込み
		filteredProducts = applyFilter(products, new PriceBelowFilter(500));
		showProducts("ワンコインで買える！", filteredProducts);

		// 1,000円以上 2,000円以下の商品に絞り込み
		filteredProducts = applyFilter(products, new PriceBetweenFilter(1_000, 2_000));
		showProducts("千円～二千円で買える！", filteredProducts);

		// 1.5Kg以下の商品に絞り込み
		filteredProducts = applyFilter(products, new WeightBelowFilter(1_500));
		showProducts("片手で持てる！", filteredProducts);

		// 1,000円以上 2,000円以下で、かつ1.5kg以下の商品に絞り込み
		filteredProducts = applyFilter
		(
			products, new CompoundFilter
			(
				new PriceBetweenFilter(1_000, 2_000), new WeightBelowFilter(1_500)
			)
		);
		showProducts("千円～二千円で片手で持てる！", filteredProducts);
	}

	/**
	 * 商品リストを作成して返す。
	 *
	 * @return 商品リスト
	 */
	private static List<Product> createProducts()
	{
		List<Product> products = new ArrayList<>();
		products.add(new Product("テントウムシ 1,500匹", 780, 453));
		products.add(new Product("５億ジンバブエドル", 3_000, 1));
		products.add(new Product("100円硬貨", 100, 5));
		products.add(new Product("ユニコーン缶詰肉", 1_240, 100));
		products.add(new Product("豚の胎児【研究用】", 1_950, 996));
		products.add(new Product("エマニエル・チェア", 1_880, 2_880));
		products.add(new Product("18金製 黄金風呂", 150_000_000, 80_000));

		return products;
	}

	/**
	 * 商品リストを画面表示する。
	 *
	 * @param title 表示タイトル
	 * @param products 商品リスト
	 */
	private static void showProducts(String title, List<Product> products)
	{
		System.out.println("─────────────────────────────");
		System.out.println("# " + title);
		System.out.println("─────────────────────────────");
		for(Product product : products)
		{
			System.out.println(product);
		}
		System.out.println("─────────────────────────────");
	}

	/**
	 * 指定された絞り込み条件に合致する商品のみに絞る。
	 *
	 * @param products 絞り込み前の商品リスト
	 * @param filter 商品絞り込みフィルター
	 * @return 絞り込み後の商品リスト
	 */
	private static List<Product> applyFilter(List<Product> products, ProductFilter filter)
	{
		List<Product> list = new ArrayList<>();
		for(Product product : products)
		{
			if(filter.isMatches(product))
			{
				list.add(product);
			}
		}

		return list;
	}
}
