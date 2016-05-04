package tests.example.example6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoExamplesTest extends Assert {


  @Test
  public void testVerifyBehaviour() {
    // Моки позволяют создавать экземпляры интерфейсов,
    // не имея их реализации. При этом можно использовать
    // методы...
    //
    Collection<String> collectionMock = mock(Collection.class);

    collectionMock.add("abc");


    // ... и даже определять поведение их методов и даже
    // последовательности возвращаемых значений!
    //
    when(collectionMock.contains(anyString())).thenReturn(true, false, true);

    assertTrue(collectionMock.contains("bla bla bla"));
    assertFalse(collectionMock.contains("bla bla bla"));
    assertTrue(collectionMock.contains("bla bla bla"));


    // Можно проверять были ли вызваны какие либо методы с
    // какими либо параметрами...
    //
    verify(collectionMock).add("abc");


    // ... или не были вызваны ни разу.
    //
    verify(collectionMock, times(0)).clear();
  }
}
