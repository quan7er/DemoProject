package cn.mldn.dao;

import java.util.List;
import java.util.Set;
import java.sql.SQLException;

/**
 * ����member���ݱ�����ݲ������׼
 * @author mldn 
 */
public interface IDAO<K,V> {
	/**
	 * ����member���ݱ��е�����
	 * @param vo Ҫ�������ݵ�VO����
	 * @return ����ɹ�����true�����򷵻�false
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public boolean doCreate(V vo) throws SQLException ;
	/**
	 * ����member�����ݵ��޸ģ������޸��ǻ���id���޸Ĵ���
	 * @param vo Ҫ�޸ĵ�ȫ������
	 * @return �޸ĳɹ�����true�����򷵻�false
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public boolean doUpdate(V vo) throws SQLException ;
	/**
	 * ���ݵ�ɾ�������Ὣ����Ҫɾ�������ݱ�����Set����֮��
	 * @param ids ����Ҫɾ����ID���
	 * @return ���Ҫɾ�����������������յ�ִ�б�׼����true�����򷵻�false
	 * @throws SQLException  ���ݿ�δ���ӣ��������ݿ��������
	 */
	public boolean doRemoveBatch(Set<K> ids) throws SQLException ;
	/**
	 * ����id��ѯ��һ���û���������Ϣ
	 * @param id Ҫ��ѯ���û�id
	 * @return ��������ҵ�����VO��������ʽ���أ�����null
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public V findById(K id) throws SQLException ;
	/**
	 * ��ѯ���ݱ��е�ȫ������
	 * @return �᷵�ض��Member���󣬽���List�ļ�����ʽ���ء�
	 * �������û�������򷵻ص�List���ϳ���Ϊ0��size() == 0��
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public List<V> findAll() throws SQLException ;
	/**
	 * ���ݵķ�ҳ��ʾ����
	 * @param currentPage ��ǰ����ҳ
	 * @param lineSize ÿҳ��ʾ����������
	 * @return �᷵�ض��Member���󣬽���List�ļ�����ʽ���ء�
	 * �������û�������򷵻ص�List���ϳ���Ϊ0��size() == 0��
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public List<V> findAllSplit(Integer currentPage,Integer lineSize) throws SQLException ;
	/**
	 * ���ݵķ�ҳ��ѯ��ʾ����
	 * @param column ��Ҫ���в�ѯ��������
	 * @param keyWord Ҫ��ѯ�Ĺؼ��֣�����ؼ���Ϊ���ַ�����ʾ��ѯȫ��
	 * @param currentPage ��ǰ����ҳ
	 * @param lineSize ÿҳ��ʾ����������
	 * @return �᷵�ض��Member���󣬽���List�ļ�����ʽ���ء�
	 * �������û�������򷵻ص�List���ϳ���Ϊ0��size() == 0��
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public List<V> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException;
	/**
	 * ͳ�����ݱ��е�ȫ��������
	 * @return ʹ��COUNT()������ͳ�ƽ��
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public Integer getAllCount() throws SQLException ;
	/**
	 * ͳ��ģ����ѯ��������
	 * @param column��Ҫ���в�ѯ��������
	 * @param keyWord Ҫ��ѯ�Ĺؼ��֣�����ؼ���Ϊ���ַ�����ʾ��ѯȫ��
	 * @return ʹ��COUNT()������ͳ�ƽ��
	 * @throws SQLException ���ݿ�δ���ӣ��������ݿ��������
	 */
	public Integer getAllCount(String column,String keyWord) throws SQLException ;
}
