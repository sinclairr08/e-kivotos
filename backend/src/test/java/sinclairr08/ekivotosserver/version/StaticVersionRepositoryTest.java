package sinclairr08.ekivotosserver.version;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StaticVersionRepositoryTest {
    @Test
    public void staticVersionRepoistoryCheck() throws Exception{
        StaticVersionRepository st = new StaticVersionRepository();

        List<Version> all = st.findAll();

        assertThat(all.get(0).getUpdates().get(0)).isEqualTo("인게임 코스트 바 구현");
    }
}