
public class LamdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LamdaInterfaceBasic lib = new LamdaInterfaceBasic();
		lib.run();
		
		OneProcess process = new OneProcess();
		process.process(
		// callback Ŭ������ lambda�� �����ϱ�
		// 1. �Լ����� ���ְ� (){} ���̿� ȭ��ǥ�� �ִ´�.
		// (int x) -> {
		// System.out.println(x);
		// }
		// 2. �Ķ���Ͱ� �ϳ��̸� Ÿ���� ������ �� �ִ�.
		// (x) -> {
		// System.out.println(x);
		// }
		// 3. �ϳ��� �Ķ���͸� �Ķ�������� ��ȣ�� ����,
		// ������ �����̸� �������� ��ȣ�� ����
		// x -> System.out.println(x)
		// 4. �Ķ���Ͱ� ������ ��ȣ�� �ݵ�� �ۼ�
		// () -> System.out.println(x)
		// 5. ���� ���� ���� ���
		// () -> return "hello"
		// 6. ������ -> ������ ����Ǵ� ���� ���ڿ� ������ �Ǵ� ���ڸ� ��Ī��  �� ������
	    // �Ķ������ ������ ���� ������ ��� ��ü :: �޼��� ���·� ȣ�� �� �� �ִ�.
			System.out::println
		);
	}
}

class OneProcess {
	public void process(One one) {
		one.run(10002);
	}
}

// 1. �ϳ��� Ŭ������ �ϳ��� �Լ� (o)

interface One {
	public void run(int x);

}
