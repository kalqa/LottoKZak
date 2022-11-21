package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

class NumberReceiverRepositoryStub implements NumberReceiverRepository {

    private final Map<LocalDateTime, List<NumberUserCoupon>> dataBaseCoupons;

    public NumberReceiverRepositoryStub() {
        dataBaseCoupons = new HashMap<>();
    }

    @Override
    public NumberUserCoupon save(NumberUserCoupon numberUserCoupon) {
        LocalDateTime dateDraw = numberUserCoupon.getDrawDate();
        List<NumberUserCoupon> numberUserCoupons = new ArrayList<>();
        if (dataBaseCoupons.containsKey(dateDraw)) {
            numberUserCoupons = dataBaseCoupons.get(dateDraw);
        }
        numberUserCoupons.add(numberUserCoupon);
        dataBaseCoupons.put(dateDraw, numberUserCoupons);
        return numberUserCoupon;
    }

    @Override
    public List<NumberUserCoupon> findAllByDrawDate(LocalDateTime drawDate) {
        if (dataBaseCoupons.containsKey(drawDate)) {
            return dataBaseCoupons.get(drawDate);
        }
        return new ArrayList<>();
    }

    @Override
    public <S extends NumberUserCoupon> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<NumberUserCoupon> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<NumberUserCoupon> findAll() {
        return null;
    }

    @Override
    public Iterable<NumberUserCoupon> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(NumberUserCoupon entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends NumberUserCoupon> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<NumberUserCoupon> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<NumberUserCoupon> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends NumberUserCoupon> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends NumberUserCoupon> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends NumberUserCoupon> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends NumberUserCoupon, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
