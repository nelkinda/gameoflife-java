module nelkinda.training.gameoflife {
    requires lombok;
    exports com.nelkinda.training.gameoflife;
    opens com.nelkinda.training.gameoflife;
    opens com.nelkinda.training.gameoflife.life2d;
    opens com.nelkinda.training.gameoflife.life3d;
}