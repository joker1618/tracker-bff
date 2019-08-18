package vari;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Car;
import org.junit.Test;
import xxx.joker.libs.core.files.JkFiles;

import java.util.ArrayList;
import java.util.List;

import static xxx.joker.libs.core.utils.JkConsole.display;

public class Vari {

    @Test
    public void vari() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream("setup/wrc6/cars.csv"));
        List<Wrc6Car> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6Car(line));
        }
        toRet.forEach(c -> display("{}", c));
    }
}
