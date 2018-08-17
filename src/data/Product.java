package data;

/**
 * 商品クラス
 *
 * @author t.yoshida
 */
public class Product
{
	// 商品名
	private String _name;

	// 価格
	private int _price;

	// 重量（g）
	private int _weight;


	/**
	 * 商品を生成する。
	 *
	 * @param name 商品名
	 * @param price 価格
	 * @param weight 重量（g）
	 */
	public Product(String name, int price, int weight)
	{
		_name = name;
		_price = price;
		_weight = weight;
	}

	/**
	 * 商品名を返す。
	 *
	 * @return 商品名
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * 価格を返す。
	 *
	 * @return 価格
	 */
	public int getPrice()
	{
		return _price;
	}

	/**
	 * 重量（g）を返す。
	 *
	 * @return 重量（g）
	 */
	public int getWeight()
	{
		return _weight;
	}

	@Override
	public String toString()
	{
		return "・" + _name + " [価格] " + String.format("%,d(円)", _price) + " [重量] " + String.format("%,d(g)", _weight);
	}
}
